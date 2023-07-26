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

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public RedirectionResponse createRedirection(@RequestBody RedirectionCreateRequest request) {
    Redirection redirection = redirectionService.create(request);
    return new RedirectionResponse(redirection);
  }

  @GetMapping("/{token}")
  @ResponseStatus(HttpStatus.OK)
  public void redirect(HttpServletResponse response, @PathVariable String token) throws IOException {
    Redirection redirection = redirectionService.redirect(token);
    response.sendRedirect(redirection.getOriginalUrl());
  }
}
