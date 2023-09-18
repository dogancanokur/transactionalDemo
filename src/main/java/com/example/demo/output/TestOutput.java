package com.example.demo.output;

import lombok.Data;

@Data
public class TestOutput {
  String message;
  Object object;

  public TestOutput(String message, Object object) {
    this.message = message;
    this.object = object;
  }
}
