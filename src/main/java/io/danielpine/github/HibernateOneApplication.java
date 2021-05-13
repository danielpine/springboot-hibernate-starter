package io.danielpine.github;

import brave.Span;
import brave.Tracer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.instrument.web.TraceWebServletAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.concurrent.Executor;

@SpringBootApplication
@EnableJpaRepositories
@Import(RepositoryRestMvcConfiguration.class)
public class HibernateOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateOneApplication.class, args);
    }

    @Bean
    public Queue logDirectQueue() {
        return new Queue("logDirectQueue");
    }

    @Bean
    public DirectExchange logDirectExchange() {
        return new DirectExchange("log.exchange.direct", false, false);
    }

    /**
     * 根据路由键绑定队列到交换器上
     *
     * @return
     */
    @Bean
    public Binding logDirectBinding() {
        return BindingBuilder.bind(logDirectQueue()).to(logDirectExchange()).with("logDirectQueue");
    }

    @Bean("taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(5);
        // 设置最大线程数
        executor.setMaxPoolSize(20);
        //配置队列大小
        executor.setQueueCapacity(Integer.MAX_VALUE);
        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(60);
        // 设置默认线程名称
        executor.setThreadNamePrefix("t-");
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //执行初始化
        executor.initialize();
        return executor;
    }


}

@Component
class DirectConsumer {
    @RabbitListener(queues = {"logDirectQueue"})
    public void processMessage(String msg) {
        System.out.println("consumer receive a message: \n" + msg);
    }
}

@Component
@Order(TraceWebServletAutoConfiguration.TRACING_FILTER_ORDER + 1)
class CustomizedHttpTraceFilter extends GenericFilterBean {

    private final Tracer tracer;

    CustomizedHttpTraceFilter(Tracer tracer) {
        this.tracer = tracer;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        Span currentSpan = this.tracer.currentSpan();
        // do nothing if current span is null
        if (currentSpan == null) {
            chain.doFilter(request, response);
            return;
        }
        // add parameter to tag
        ObjectMapper mapper = new ObjectMapper();
        currentSpan.tag("Http.parameter", mapper.writeValueAsString(request.getParameterMap()));
        chain.doFilter(request, response);
    }
}