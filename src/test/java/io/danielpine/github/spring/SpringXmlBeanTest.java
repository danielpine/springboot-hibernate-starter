package io.danielpine.github.spring;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SpringXmlBeanTest {
    @Test
    public void xmlBeanFactoryTest() {
        System.out.println("Starting..");
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));
        TestBean myTestBean = (TestBean) bf.getBean("testBean");
        System.out.println(myTestBean.getName());
    }
}
