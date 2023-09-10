package com.hscoreserver.hscorespring.question;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/questions")
@RequiredArgsConstructor
public class QuestionController {

  private final QuestionService questionService;

  @GetMapping("/{questionSetId}")
  public List<QuestionResponse> list(@PathVariable Long questionSetId) {
    List<Question> questions = questionService.getQuestions(questionSetId);
    return questions.stream()
        .map(QuestionResponse::new)
        .toList();
  }
}
