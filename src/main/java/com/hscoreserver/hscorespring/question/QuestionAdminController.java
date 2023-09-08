package com.hscoreserver.hscorespring.question;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/questions")
@RequiredArgsConstructor
public class QuestionAdminController {

  private final QuestionService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Question create(@RequestBody @Valid QuestionCreateRequest request) {
    return service.createQuestion(request);
  }
}
