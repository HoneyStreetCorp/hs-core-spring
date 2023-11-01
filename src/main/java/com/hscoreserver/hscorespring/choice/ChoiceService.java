package com.hscoreserver.hscorespring.choice;

import com.hscoreserver.hscorespring.error.ErrorCode;
import com.hscoreserver.hscorespring.error.exception.NotFoundException;
import com.hscoreserver.hscorespring.question.Question;
import com.hscoreserver.hscorespring.question.QuestionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChoiceService {

  private final QuestionService questionService;
  private final ChoiceRepository repository;

  public Choice createChoice(Long questionId, ChoiceCreateRequest request) {
    Question question = questionService.getQuestion(questionId);
    Choice choice = Choice.createChoice(request, question);
    return repository.save(choice);
  }

  public List<Choice> createBulkChoice(Long questionId, List<ChoiceCreateRequest> requests) {
    Question question = questionService.getQuestion(questionId);

    List<Choice> choices = requests.stream()
        .map(request -> Choice.createChoice(request, question))
        .toList();

    return repository.saveAll(choices);
  }

  public Choice getChoice(Long choiceId) {
    return repository.findById(choiceId)
        .orElseThrow(() -> new NotFoundException(ErrorCode.CHOICE_NOT_FOUND, "Choice id : " + choiceId));
  }
}
