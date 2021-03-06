package com.sandbox.coursemc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.coursemc.domain.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer>{

}
