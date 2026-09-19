package com.example.springdemo170.entity;

import com.example.springdemo170.model.Customer;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer birthdate;
    private Integer age;

//    Unidirectional One to Many
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id")

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductEntity> products = new ArrayList<>();

    public CustomerEntity() {}

    public CustomerEntity(Long id, String name, Integer birthdate,Integer age,List<ProductEntity> products) {
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
    public void setBirthdate(Integer birthdate) { this.birthdate= birthdate; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public List<ProductEntity> getProducts() { return products; }
    public void setProducts(List<ProductEntity> products) { this.products = products; }
}