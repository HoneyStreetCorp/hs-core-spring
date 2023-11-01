package com.hscoreserver.hscorespring.submit;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/submits")
public class SubmitController {

  private final SubmitService submitService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public List<SubmitResponse> submit(List<SubmitCreateRequest> requests) {
    List<Submit> submits = submitService.submit(requests);
    return submits.stream()
        .map(Submit::toResponse)
        .toList();
  }
}
