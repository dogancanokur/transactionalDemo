package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Beverage;

@Repository
public interface BeverageRepository extends JpaRepository<Beverage, Long> {

}
