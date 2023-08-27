package com.hscoreserver.hscorespring.questionSet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum QuestionSetName {
  RELATION("연애");

  private final String name;
}
