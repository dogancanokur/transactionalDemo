package com.example.demo.service.impl;

import com.example.demo.entity.Food;
import com.example.demo.exception.ApiException;
import com.example.demo.repository.FoodRepository;
import com.example.demo.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
        saveTransaction(food);
    }

    @Override
    public void saveTransaction(Food food) throws ApiException {
        foodRepository.save(food);
//        throw new ApiException("test");

    }
}

