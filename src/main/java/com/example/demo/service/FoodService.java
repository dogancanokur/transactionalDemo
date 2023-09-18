package com.example.demo.service;

import com.example.demo.entity.Food;
import com.example.demo.exception.ApiException;

public interface FoodService {

  void saveTransaction() throws ApiException;

  void saveTransaction(Food food) throws ApiException;

}
