package com.hscoreserver.hscorespring.questionSet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionSetService {

  private final QuestionSetRepository questionSetRepository;

  public QuestionSet createQuestionSet(String name) {
    QuestionSet questionSet = QuestionSet.builder()
        .name(name)
        .build();

    return questionSetRepository.save(questionSet);
  }
}
