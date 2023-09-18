package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.ApiException;
import com.example.demo.output.TestOutput;
import com.example.demo.service.BeverageService;
import com.example.demo.service.FoodService;
import com.example.demo.service.ItemService;
import com.example.demo.service.TestService;

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
  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { ApiException.class })
  public TestOutput txTestFirstCall() throws ApiException {

    return txTestSecondCall();
  }

  private TestOutput txTestSecondCall() throws ApiException {
    itemService.save();

    try {
      foodService.saveTransaction();
    } catch (ApiException e) {
      TestOutput testOutput = new TestOutput(e.getMessage(), e.getObject());
      // return testOutput;
      throw new ApiException(e.getMessage(), testOutput);
    }
    beverageService.save();
    return new TestOutput("method ok", null);
  }
}
