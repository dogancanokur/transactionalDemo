package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.service.BeverageService;
import com.example.demo.service.FoodService;
import com.example.demo.service.ItemService;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TxServiceImpl implements TestService {
    private final ItemService itemService;
    private final FoodService foodService;
    private final BeverageService beverageService;

    @Autowired
    public TxServiceImpl(ItemService itemService, FoodService foodService, BeverageService beverageService) {
        this.itemService = itemService;
        this.foodService = foodService;
        this.beverageService = beverageService;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void txTestFirstCall() throws Exception {
//        try{

        txTestSecondCall();
//        }catch (Exception e){
//            System.out.println("Exception: " + e.getMessage());
//        }
    }

    private void txTestSecondCall() throws Exception {
        itemService.save();
        try {
            foodService.saveTransaction();
        } catch (ApiException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        beverageService.save();
    }
}
