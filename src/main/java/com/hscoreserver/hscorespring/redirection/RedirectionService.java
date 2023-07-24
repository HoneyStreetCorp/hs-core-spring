package com.hscoreserver.hscorespring.redirection;

import com.hscoreserver.hscorespring.error.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedirectionService {
  private final RedirectionRepository redirectionRepository;

  public Redirection create(RedirectionCreateRequest request) {
    Redirection redirection = new Redirection(request.getOriginalUrl());
    return redirectionRepository.save(redirection);
  }

  public Redirection redirect(String token) {
    return redirectionRepository.findById(token)
        .orElseThrow(() -> new NotFoundException("Invalid token"));
  }
}
