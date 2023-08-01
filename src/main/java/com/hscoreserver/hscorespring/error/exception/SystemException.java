package com.hscoreserver.hscorespring.error.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SystemException extends RuntimeException {

  private final HttpStatus status;

  public SystemException(String message, HttpStatus status) {
    super(message);
    this.status = status;
  }
}
