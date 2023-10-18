package com.hscoreserver.hscorespring.error.exception;

import com.hscoreserver.hscorespring.error.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundException extends SystemException {

  private final String message;

  public NotFoundException(ErrorCode errorCode, String message) {
    super(errorCode);
    this.message = message;
  }
}
