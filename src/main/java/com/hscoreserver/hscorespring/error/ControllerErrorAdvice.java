package com.hscoreserver.hscorespring.error;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerErrorAdvice {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleException(Exception e) {
    log.error("Exception occurs: {}", e.getMessage());
    ErrorResponse errorResponse = ErrorResponse.of(INTERNAL_SERVER_ERROR.toString(), e.getMessage());
    return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(errorResponse);
  }

}
