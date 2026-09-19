package com.example.springdemo170.controller;

import com.example.springdemo170.model.Product;
import com.example.springdemo170.service.ProductService;
import org.springframework.jmx.export.naming.IdentityNamingStrategy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 1. GET API
    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    // 2. ID  GET API
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    // 3. POST API
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // 4. ID DELETE API
    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable Integer id) {
        return productService.deleteProduct(id);
    }

    // 5. ID update PUT API
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }
}