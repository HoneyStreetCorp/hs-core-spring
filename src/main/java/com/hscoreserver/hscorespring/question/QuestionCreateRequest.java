package com.hscoreserver.hscorespring.question;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class QuestionCreateRequest {

  @NotEmpty
  private String title;

  @NotEmpty
  private String body;

  @NotEmpty
  private Category category;

  @NotEmpty
  private Long questionSetId;
}
