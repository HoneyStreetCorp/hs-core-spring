package com.hscoreserver.hscorespring.question;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
  ONE("one"), TWO("two");

  private final String category;
}
