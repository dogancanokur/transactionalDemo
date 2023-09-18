package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@Getter
@ResponseStatus(reason = "Api Exception", value = HttpStatus.NOT_FOUND)
public class ApiException extends Exception {
  private Object object;
  public ApiException(String message) {
    super(message);
  }

  public ApiException(String message, Object object) {
    super(message);
    this.object = object;
  }

}
