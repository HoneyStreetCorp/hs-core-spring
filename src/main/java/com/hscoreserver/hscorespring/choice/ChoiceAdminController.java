package com.hscoreserver.hscorespring.choice;

import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/choices")
@RequiredArgsConstructor
public class ChoiceAdminController {

  private final ChoiceService service;

  @PostMapping("/{questionId}")
  @ResponseStatus(HttpStatus.CREATED)
  public ChoiceResponse create(
      @PathVariable Long questionId,
      @RequestBody @Valid ChoiceCreateRequest request
  ) {
    Choice choice = service.createChoice(questionId, request);
    return new ChoiceResponse(choice);
  }

  @PostMapping("/bulk/{questionId}")
  @ResponseStatus(HttpStatus.CREATED)
  public List<ChoiceResponse> createBulk(
      @PathVariable Long questionId,
      @RequestBody @Valid List<ChoiceCreateRequest> requests
  ) {
    List<Choice> choices = service.createBulkChoice(questionId, requests);
    return choices.stream()
        .map(ChoiceResponse::new)
        .toList();
  }
}
