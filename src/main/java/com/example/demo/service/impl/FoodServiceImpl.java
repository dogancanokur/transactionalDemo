package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Food;
import com.example.demo.exception.ApiException;
import com.example.demo.repository.FoodRepository;
import com.example.demo.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {
  private final FoodRepository foodRepository;

  @Autowired
  public FoodServiceImpl(FoodRepository foodRepository) {
    this.foodRepository = foodRepository;
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public void saveTransaction() throws ApiException {

    Food food = new Food();
    food.setName("test");
    food.setDescription("test");

    if (true) {
      throw new ApiException("saveTransaction api exception ", new Food());
    }

    saveTransaction(food);
  }

  private void saveTransaction(Food food) {
    // try {
    // Transactional işlemler burada gerçekleştirilir
    foodRepository.save(food);
    // } catch (Exception e) {
    // TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    // throw e;
    // }
  }
}
