package com.example;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="bean_d")
public class BeanD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bean_a_id")
    private BeanA beanA;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<BeanC> beanCs;

    public Long getId() {
        return id;
    }

    public BeanA getBeanA() {
        return beanA;
    }
}

