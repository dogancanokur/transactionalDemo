package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Item;
import com.example.demo.service.TestService;

@Controller
public class TxController {
  private final TestService service;

  @Autowired
  public TxController(TestService service) {
    this.service = service;
  }

  @GetMapping("/tx")
  public ResponseEntity<?> testTransactional() {
    Item item = new Item();
    item.setName("test test");
    item.setDescription("testDesc");
    try {
      service.txTestFirstCall();

    } catch (Exception e) {
      // System.out.println("Exception: " + e.getMessage());
    }
    return ResponseEntity.ok().build();
  }

}
