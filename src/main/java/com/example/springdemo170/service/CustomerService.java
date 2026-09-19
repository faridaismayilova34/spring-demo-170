package com.example.springdemo170.service;

import com.example.springdemo170.entity.CustomerEntity;
import com.example.springdemo170.model.Customer;
import com.example.springdemo170.model.Product;
import com.example.springdemo170.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private Customer mapToDto(CustomerEntity entity) {
        if (entity == null) return null;

        List<Product> productDtos = null;
        if (entity.getProducts() != null) {
            productDtos = entity.getProducts().stream()
                    .map(p -> new Product(p.getId(), p.getName(), p.getPrice(), p.getCategory()))
                    .toList();
        }

        return new Customer(
                entity.getId(),
                entity.getName(),
                entity.getBirthdate(),
                entity.getAge(),
                productDtos
        );
    }

    public Customer getCustomerWithProducts(Long id) {
        CustomerEntity customerEntity = customerRepository.findByIdWithProducts(id)
                .orElseThrow(() -> new RuntimeException("Customer not found: " + id));

        return mapToDto(customerEntity);
    }
}