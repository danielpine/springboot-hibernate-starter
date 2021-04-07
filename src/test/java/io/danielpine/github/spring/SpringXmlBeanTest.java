package io.danielpine.github.spring;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
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

    @Test
    public void xmlBeanFactoryTest2() {
        System.out.println("Starting..");
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("spring-config.xml"));
        TestBean myTestBean = (TestBean) defaultListableBeanFactory.getBean("testBean");
        System.out.println(myTestBean.getName());
    }

}
