package com.hscoreserver.hscorespring.question;

import com.hscoreserver.hscorespring.questionSet.QuestionSet;
import com.hscoreserver.hscorespring.questionSet.QuestionSetService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {

  private final QuestionSetService questionSetService;
  private final QuestionRepository questionRepository;

  public List<Question> getQuestions(String questionSetName) {
    QuestionSet questionSet = questionSetService.getQuestionSet(questionSetName);
    return questionRepository.findByQuestionSet(questionSet.getId());
  }
}
