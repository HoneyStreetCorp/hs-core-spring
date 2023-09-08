package com.hscoreserver.hscorespring.question;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {

  private final QuestionRepository repository;

  public List<Question> getQuestions(Long questionSetId) {
    return repository.findByQuestionSet(questionSetId);
  }

  public Question createQuestion(QuestionCreateRequest request) {
    Question question = Question.createQuestion(request);
    return repository.save(question);
  }
}
