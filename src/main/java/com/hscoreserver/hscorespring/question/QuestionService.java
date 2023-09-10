package com.hscoreserver.hscorespring.question;

import com.hscoreserver.hscorespring.error.ErrorCode;
import com.hscoreserver.hscorespring.error.exception.NotFoundException;
import com.hscoreserver.hscorespring.questionSet.QuestionSet;
import com.hscoreserver.hscorespring.questionSet.QuestionSetService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {

  private final QuestionSetService questionSetService;
  private final QuestionRepository repository;

  public List<Question> getQuestions(Long id) {
    return repository.findByQuestionSet(id);
  }

  public Question getQuestion(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new NotFoundException(ErrorCode.QUESTION_NOT_FOUND, "id = " + id));
  }

  public Question createQuestion(QuestionCreateRequest request) {
    QuestionSet questionSet = questionSetService.getQuestionSet(request.getQuestionSetId());
    Question question = Question.createQuestion(request, questionSet);
    return repository.save(question);
  }
}
