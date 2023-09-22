package com.example;

public class BeanB {
    private BeanC beanC;

    public void setBeanC(BeanC beanC) {
        this.beanC = beanC;
    }
    public BeanC getBeanC() {
        return this.beanC;
    }

    public void doSomething() {
        beanC.doSomething();
    }
}
