package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        BeanA beanA = context.getBean(BeanA.class);

        System.out.println("BeanA: " + beanA);
        System.out.println("BeanB inside BeanA: " + beanA.getBeanB());
        System.out.println("BeanC inside BeanB: " + beanA.getBeanB().getBeanC());
        System.out.println("Property inside BeanC: " + beanA.getBeanB().getBeanC().getProperty());

        beanA.doSomething();
    }
}
