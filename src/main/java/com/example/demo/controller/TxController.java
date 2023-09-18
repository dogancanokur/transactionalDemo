package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.exception.ApiException;
import com.example.demo.output.TestOutput;
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
    try {
      TestOutput testOutput = service.txTestFirstCall();
      return ResponseEntity.ok().body(testOutput);
    } catch (ApiException e) {
      return ResponseEntity.badRequest().body(e.getObject());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
