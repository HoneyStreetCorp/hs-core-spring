package com.hscoreserver.hscorespring.error.exception;

import com.hscoreserver.hscorespring.error.ErrorCode;
import lombok.Getter;

@Getter
public class NotFoundException extends SystemException {

  public NotFoundException(ErrorCode errorCode, String message) {
    super(errorCode.getMessage() + message, errorCode.getStatus());
  }
}
