package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="bean_b")
public class BeanB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int age;

    @ManyToOne
    @JoinColumn(name = "bean_a_id")
    private BeanA beanA;

    @OneToMany(mappedBy="beanB")
    private List<BeanC> beanCs;

    public int getAge() {
        return age;
    }

    public List<BeanC> getBeanCs() {
        return beanCs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBeanA(BeanA beanA) {
        this.beanA = beanA;
    }

}
