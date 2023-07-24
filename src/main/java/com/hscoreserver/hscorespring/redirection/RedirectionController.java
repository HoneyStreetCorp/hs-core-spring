package com.hscoreserver.hscorespring.redirection;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/redirections")
public class RedirectionController {
  private final RedirectionService redirectionService;

  // TODO(@hoo): response 클래스 만들기
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Redirection createRedirection(@RequestBody RedirectionCreateRequest request) {
    return redirectionService.create(request);
  }

  @GetMapping("/{token}")
  @ResponseStatus(HttpStatus.OK)
  public void redirect(HttpServletResponse response, @PathVariable String token) throws IOException {
    Redirection redirection = redirectionService.redirect(token);
    response.sendRedirect(redirection.getOriginalUrl());
  }
}
