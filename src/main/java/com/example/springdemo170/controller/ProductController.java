package com.example.springdemo170.controller;

import com.example.springdemo170.model.Product;
import com.example.springdemo170.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 1. Bütün məhsulları qaytaran GET API
    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    // 2. ID üzrə 1 məhsul qaytaran GET API
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    // 3. Yeni məhsul əlavə edən POST API
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // 4. ID üzrə məhsulu silən DELETE API
    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

    // 5. ID üzrə məhsulu update edən PUT API
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }
}