package com.hscoreserver.hscorespring.submit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
public class SubmitResponse {

  private Long userId;
  private Long id;
  private Long questionId;
  private String answer;
  private Long choiceId;


}
