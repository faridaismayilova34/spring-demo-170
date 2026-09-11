package com.example.springdemo170.repository;

import com.example.springdemo170.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    public List<Product> findAll() {
        return new ArrayList<>();
    }
}
