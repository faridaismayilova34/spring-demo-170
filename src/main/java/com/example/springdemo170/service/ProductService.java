package com.example.springdemo170.service;

import com.example.springdemo170.entity.ProductEntity;
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

    // 1. GET ALL
    public List<Product> getProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productEntities.stream().map(
                productEntity -> new Product(
                        productEntity.getId(),
                        productEntity.getName(),
                        productEntity.getPrice(),
                        productEntity.getCategory()
                )
        ).toList();
    }

    // 2. GET BY ID
    public Product getProductById(Integer id) {
        return productRepository.findById(id)
                .map(productEntity -> new Product(
                        productEntity.getId(),
                        productEntity.getName(),
                        productEntity.getPrice(),
                        productEntity.getCategory()
                ))
                .orElse(null);
    }

    // 3. ADD PRODUCT
    public Product addProduct(Product productDto) {
        ProductEntity entity = new ProductEntity();
        entity.setName(productDto.getName());
        entity.setPrice(productDto.getPrice());
        entity.setCategory(productDto.getCategory());

        ProductEntity savedEntity = productRepository.save(entity);

        return new Product(
                savedEntity.getId(),
                savedEntity.getName(),
                savedEntity.getPrice(),
                savedEntity.getCategory()
        );
    }

    // 4. DELETE PRODUCT
    public boolean deleteProduct(Integer id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // 5. UPDATE PRODUCT
    public Product updateProduct(Integer id, Product productDto) {
        return productRepository.findById(id)
                .map(existingEntity -> {
                    existingEntity.setName(productDto.getName());
                    existingEntity.setCategory(productDto.getCategory());
                    existingEntity.setPrice(productDto.getPrice());

                    ProductEntity updatedEntity = productRepository.save(existingEntity);

                    return new Product(
                            updatedEntity.getId(),
                            updatedEntity.getName(),
                            updatedEntity.getPrice(),
                            updatedEntity.getCategory()
                    );
                })
                .orElse(null);
    }



    public String getCustomerNameByProductId(Integer productId) {
        ProductEntity product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getCustomer() != null) {
            return product.getCustomer().getName();
        }
        return "Customer not found";
    }


}