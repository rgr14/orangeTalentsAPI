package com.orangetalents.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orangetalents.model.Car;

public interface CarRepository extends JpaRepository<Car, Long>{

}
