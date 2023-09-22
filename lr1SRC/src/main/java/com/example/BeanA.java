package com.example;

public class BeanA {
    private BeanB beanB;

    public BeanA(BeanB beanB) {
        this.beanB = beanB;
    }

    public void doSomething() {
        beanB.doSomething();
    }

    public BeanB getBeanB() { return this.beanB; }
}
