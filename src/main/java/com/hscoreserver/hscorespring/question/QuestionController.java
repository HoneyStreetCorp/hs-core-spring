package com.hscoreserver.hscorespring.question;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/questions")
@RequiredArgsConstructor
public class QuestionController {

  private final QuestionService questionService;

  @GetMapping("/{category}")
  public Page<QuestionResponse> getQuestions(@PathVariable Category category, Pageable pageable) {
    Page<Question> page = questionService.get(category, pageable);
    return page.map(QuestionResponse::new);
  }

}
