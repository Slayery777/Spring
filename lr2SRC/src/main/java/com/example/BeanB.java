package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanB {
    private BeanC beanC;

    @Autowired
    public void setBeanC(BeanC beanC) {
        this.beanC = beanC;
    }

    public void doSomething() {
        beanC.doSomething();
    }
}
