package io.danielpine.github;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.instrument.web.TraceWebServletAutoConfiguration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.fasterxml.jackson.databind.ObjectMapper;

import brave.Span;
import brave.Tracer;

@SpringBootApplication
public class HibernateOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateOneApplication.class, args);
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