package com.hscoreserver.hscorespring.choice;

public record ChoiceResponse(
    Long id,
    int number,
    String content
) {


  public ChoiceResponse(Choice choice) {
    this(choice.getId(), choice.getNumber(), choice.getContent());
  }
}
