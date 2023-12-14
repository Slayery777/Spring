package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.*;

@Entity
@Table(name="bean_c")
public class BeanC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    @ManyToOne
    @JoinColumn(name = "bean_b_id")
    private BeanB beanB;

    @PostConstruct
    public void init() {
        System.out.println("BeanC is initialized with property: " + id);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("BeanC is being destroyed");
    }

    public void doSomething() {
        System.out.println(id);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BeanB getBeanB() {
        return beanB;
    }

    public void setBeanB(BeanB beanB) {
        this.beanB = beanB;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
