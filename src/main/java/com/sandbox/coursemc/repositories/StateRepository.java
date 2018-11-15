package com.sandbox.coursemc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.coursemc.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{

}
