package com.example.demo.service.impl;

import com.example.demo.entity.Beverage;
import com.example.demo.repository.BeverageRepository;
import com.example.demo.service.BeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeverageServiceImpl implements BeverageService {
    private final BeverageRepository repository;

    @Autowired
    public BeverageServiceImpl(BeverageRepository repository) {
        this.repository = repository;
    }

    @Override
//    @Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
    public void save() {
        Beverage beverage = new Beverage();
//        beverage.setName("null");
        beverage.setDescription("testDesc");
        repository.save(beverage);
    }
}
