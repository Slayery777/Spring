package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanC {
    @Value("${my.property}")
    private String property;

    @PostConstruct
    public void init() {
        System.out.println("BeanC is initialized with property: " + property);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("BeanC is being destroyed");
    }

    public void doSomething() {
        System.out.println(property);
    }
}
