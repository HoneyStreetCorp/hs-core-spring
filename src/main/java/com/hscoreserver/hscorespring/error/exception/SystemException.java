package com.hscoreserver.hscorespring.error.exception;

import com.hscoreserver.hscorespring.error.ErrorCode;
import lombok.Getter;

@Getter
public class SystemException extends RuntimeException {

  private final ErrorCode errorCode;

  public SystemException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }
}
