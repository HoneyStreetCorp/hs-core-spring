package com.hscoreserver.hscorespring.error;

public class NotFoundException extends RuntimeException {

  // TODO(@Hoo): 에러 구체화 하기
  public NotFoundException(String message) {
    super(message);
  }
}
