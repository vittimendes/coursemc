package com.sandbox.coursemc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.coursemc.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
