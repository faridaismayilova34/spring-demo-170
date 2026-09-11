package com.example.springdemo170;

import com.example.springdemo170.controller.ProductController;
import com.example.springdemo170.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringDemo170Application {

    public static void main(String[] args) {

        // ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ApplicationContext context = SpringApplication.run(SpringDemo170Application.class, args);

        ProductController controller = context.getBean(ProductController.class);
        List<Product> products = controller.getProducts();

        System.out.println("Result: " + products); // []
    }
}

