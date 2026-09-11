package com.example.springdemo170.controller;

import com.example.springdemo170.model.Product;
import com.example.springdemo170.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductController {
    @Autowired
    private ProductService productService;

    public List<Product> getProducts() {
        return productService.getProducts();
    }
}
