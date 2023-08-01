package com.hscoreserver.hscorespring.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

  USER_NOT_FOUND(HttpStatus.NOT_FOUND, "U001","User not found. Detail:"),

  REDIRECTION_NOT_FOUND(HttpStatus.NOT_FOUND, "R001","Redirection not found. Detail: ");

  private final HttpStatus status;
  private final String code;
  private final String message;

  ErrorCode(HttpStatus status, String code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;
  }
}
