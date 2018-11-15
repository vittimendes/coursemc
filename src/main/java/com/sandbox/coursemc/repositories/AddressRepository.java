package com.sandbox.coursemc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.coursemc.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
