package com.example;

public class BeanC {
    private String property;

    public void setProperty(String property) {
        this.property = property;
    }
    public String getProperty() {
        return this.property;
    }
    public void doSomething() {
        System.out.println(property);
    }
}
