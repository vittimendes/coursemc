package com.sandbox.coursemc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.coursemc.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
