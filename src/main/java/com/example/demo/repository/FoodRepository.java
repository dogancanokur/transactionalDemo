package com.example.demo.repository;

import com.example.demo.entity.Food;
import com.example.demo.exception.ApiException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    Food findById(long id) throws ApiException;
}
