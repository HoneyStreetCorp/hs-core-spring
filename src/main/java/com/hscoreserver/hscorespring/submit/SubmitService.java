package com.hscoreserver.hscorespring.submit;

import com.hscoreserver.hscorespring.choice.Choice;
import com.hscoreserver.hscorespring.choice.ChoiceService;
import com.hscoreserver.hscorespring.question.Question;
import com.hscoreserver.hscorespring.question.QuestionService;
import com.hscoreserver.hscorespring.user.User;
import com.hscoreserver.hscorespring.user.UserService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubmitService {

  private final SubmitRepository submitRepository;
  private final QuestionService questionService;
  private final ChoiceService choiceService;
  private final UserService userService;

  public List<Submit> submit(List<SubmitCreateRequest> requests) {
    List<Submit> submits = new ArrayList<>();

    for (SubmitCreateRequest request : requests) {
      Choice choice = choiceService.getChoice(request.getChoiceId());
      Question question = questionService.getQuestion(request.getQuestionId());
      User user = userService.getUserById(request.getUserId());
      Submit submit = Submit.createSubmit(question, choice, user, request.getAnswer());
      submits.add(submit);
    }

    return submitRepository.saveAll(submits);
  }
}
