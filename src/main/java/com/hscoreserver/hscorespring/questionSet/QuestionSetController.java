package com.hscoreserver.hscorespring.questionSet;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/question-set")
@RequiredArgsConstructor
public class QuestionSetController {

  private final QuestionSetService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public QuestionSet create(@RequestParam String name) {
    return service.createQuestionSet(name);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    service.deleteQuestionSet(id);
  }
}
