package com.example.springdemo170.repository;


import com.example.springdemo170.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Phone", "500"));
        products.add(new Product(2, "Laptop", "1500"));
    }

    public List<Product> findAll() {
        return products;
    }

    public Product findById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Product save(Product product) {
        products.add(product);
        return product;
    }

    public boolean deleteById(int id) {
        return products.removeIf(p -> p.getId() == id);
    }

    public Product update(int id, Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                updatedProduct.setId(id);
                products.set(i, updatedProduct);
                return updatedProduct;
            }
        }
        return null;
    }
}