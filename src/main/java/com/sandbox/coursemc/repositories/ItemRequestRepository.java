package com.sandbox.coursemc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.coursemc.domain.ItemRequest;

@Repository
public interface ItemRequestRepository extends JpaRepository<ItemRequest, Integer>{

}
