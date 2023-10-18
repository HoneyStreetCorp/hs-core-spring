package com.hscoreserver.hscorespring.choice;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ChoiceCreateRequest {

  private int number;

  @NotEmpty
  private String content;
}
