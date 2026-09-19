package com.example.springdemo170.model;

import java.util.List;

public class Customer {
    private Long id;
    private String name;
    private Integer birthdate;
    private Integer age;
    private List<Product> products;

    public Customer() {}

    public Customer(Long id, String name, Integer birthdate, Integer age, List<Product> products) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.age = age;
        this.products = products;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getBirthdate() { return birthdate; }
    public void setBirthdate(Integer birthdate) { this.birthdate = birthdate; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
}