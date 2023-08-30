package com.hscoreserver.hscorespring.question;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {

  private final QuestionRepository questionRepository;

  public List<Question> getQuestions(Long questionSetId) {
    return questionRepository.findByQuestionSet(questionSetId);
  }
}
