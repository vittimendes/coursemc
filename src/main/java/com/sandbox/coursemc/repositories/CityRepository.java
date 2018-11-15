package com.sandbox.coursemc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandbox.coursemc.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{

}
