package com.hscoreserver.hscorespring.error;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.hscoreserver.hscorespring.error.exception.NotFoundException;
import com.hscoreserver.hscorespring.error.exception.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerErrorAdvice {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleException(Exception e) {
    log.error("Exception occurs: {}", e.getMessage());
    ErrorResponse errorResponse = ErrorResponse.of(INTERNAL_SERVER_ERROR.toString(),
        e.getMessage());
    return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(errorResponse);
  }

  @ExceptionHandler(BindException.class)
  public ResponseEntity<ErrorResponse> handleBindException(BindException e) {
    log.error("Exception occurs: {}", e.getMessage());
    ErrorResponse errorResponse = ErrorResponse.of(BAD_REQUEST.toString(), e.getBindingResult());
    return ResponseEntity.status(BAD_REQUEST).body(errorResponse);
  }

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public ResponseEntity<ErrorResponse> handleMissingServletRequestParameterException(
      MissingServletRequestParameterException e
  ) {
    log.error("Exception occurs: {}", e.getMessage());
    ErrorResponse errorResponse = ErrorResponse.of(BAD_REQUEST.toString(), e.getMessage());
    return ResponseEntity.status(BAD_REQUEST).body(errorResponse);
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {
    log.error("Exception occurs: {}", e.getMessage());
    ErrorResponse errorResponse = ErrorResponse.of(NOT_FOUND.toString(), e.getMessage());
    return ResponseEntity.status(NOT_FOUND).body(errorResponse);
  }

  @ExceptionHandler(SystemException.class)
  public ResponseEntity<ErrorResponse> handleSystemException(SystemException e) {
    log.error("Exception occurs: {}", e.getMessage());
    ErrorResponse errorResponse = ErrorResponse.of(e.getStatus().toString(), e.getMessage());
    return ResponseEntity.status(e.getStatus()).body(errorResponse);
  }
}
