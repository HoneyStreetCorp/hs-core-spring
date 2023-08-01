package com.hscoreserver.hscorespring.redirection;


import java.net.URI;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public RedirectionResponse createRedirection(
      @RequestBody @Valid RedirectionCreateRequest request) {
    Redirection redirection = redirectionService.create(request);
    return new RedirectionResponse(redirection);
  }

  @GetMapping("/{token}")
  public ResponseEntity<Void> redirect(@PathVariable String token) {
    Redirection redirection = redirectionService.getRedirection(token);
    return ResponseEntity.status(HttpStatus.TEMPORARY_REDIRECT)
        .location(URI.create(redirection.getOriginalUrl()))
        .build();
  }
}
