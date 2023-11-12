package com.example;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* com.example.BeanA.doSomething(..))")
    public void beanAPointcut() {}

    @Pointcut("execution(* com.example.BeanB.doSomething(..))")
    public void beanBPointcut() {}

    @Pointcut("execution(* com.example.BeanC.doSomething(..))")
    public void beanCPointcut() {}

    @Before("beanAPointcut()")
    public void beforeBeanAAdvice() {
        System.out.println("Before BeanA's doSomething method");
    }

    @After("beanBPointcut()")
    public void afterBeanBAdvice() {
        System.out.println("After BeanB's doSomething method");
    }

    @Before("beanCPointcut()")
    public void beforeBeanCAdvice() {
        System.out.println("Before BeanC's doSomething method");
    }

    @Pointcut("beanAPointcut() && beanBPointcut()")
    public void combinedPointcut() {}

    @Before("combinedPointcut()")
    public void beforeCombinedAdvice() {
        System.out.println("Before BeanA's and BeanB's doSomething methods");
    }
}
