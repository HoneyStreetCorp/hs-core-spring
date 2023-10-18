package com.hscoreserver.hscorespring.question;

import com.hscoreserver.hscorespring.choice.ChoiceResponse;
import java.util.List;


public record QuestionResponse(
    Long id,
    String title,
    String body,
    Category category,
    Long questionSetId,
    String questionSetName,
    List<ChoiceResponse> choices
) {

  public QuestionResponse(Question question) {
    this(
        question.getId(),
        question.getTitle(),
        question.getBody(),
        question.getCategory(),
        question.getQuestionSet().getId(),
        question.getQuestionSet().getName(),
        question.getChoices().stream()
            .map(ChoiceResponse::new)
            .toList()
    );
  }
}
