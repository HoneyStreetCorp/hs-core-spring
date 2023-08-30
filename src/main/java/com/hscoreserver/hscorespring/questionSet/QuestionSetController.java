package com.hscoreserver.hscorespring.questionSet;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/question-set")
@RequiredArgsConstructor
public class QuestionSetController {

  private final QuestionSetService questionSetService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public QuestionSet create(@RequestParam String name) {
    return questionSetService.createQuestionSet(name);
  }
}
