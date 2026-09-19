package com.example.springdemo170.repository;

import com.example.springdemo170.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
    @Query("select c from CustomerEntity c left join fetch c.products where c.id = :id")
    Optional<CustomerEntity> findByIdWithProducts(@Param("id") Long id);
}
