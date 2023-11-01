package com.hscoreserver.hscorespring.submit;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SubmitCreateRequest {

  private Long userId;

  private Long questionId;

  private String answer;

  private Long choiceId;
}
