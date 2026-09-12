package com.example.springdemo170.service;

import com.example.springdemo170.model.Product;
import com.example.springdemo170.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public boolean deleteProduct(int id) {
        return productRepository.deleteById(id);
    }

    public Product updateProduct(int id, Product product) {
        return productRepository.update(id, product);
    }
}