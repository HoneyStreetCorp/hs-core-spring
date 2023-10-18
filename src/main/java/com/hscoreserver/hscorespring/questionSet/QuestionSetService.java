package com.hscoreserver.hscorespring.questionSet;

import com.hscoreserver.hscorespring.error.ErrorCode;
import com.hscoreserver.hscorespring.error.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionSetService {

  private final QuestionSetRepository repository;

  public QuestionSet createQuestionSet(String name) {
    QuestionSet questionSet = QuestionSet.builder()
        .name(name)
        .build();

    return repository.save(questionSet);
  }

  public void deleteQuestionSet(Long id) {
    QuestionSet questionSet = repository.findById(id)
        .orElseThrow(() -> new NotFoundException(ErrorCode.QUESTION_SET_NOT_FOUND, "id = " + id));

    repository.delete(questionSet);
  }

  public QuestionSet getQuestionSet(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new NotFoundException(ErrorCode.QUESTION_SET_NOT_FOUND, "id = " + id));
  }
}
