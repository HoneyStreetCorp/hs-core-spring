package com.hscoreserver.hscorespring.redirection;

import com.hscoreserver.hscorespring.util.Base62Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedirectionService {

  private final RedirectionRepository redirectionRepository;

  public Redirection getRedirection(String token) {
    return redirectionRepository.findById(token)
        .orElseThrow(() -> new IllegalArgumentException("Invalid token"));
  }

  public Redirection createRedirection(RedirectionCreateRequest redirectionCreateRequest) {
   Redirection redirection = Redirection.builder()
       .token(Base62Util.generateBase62())
       .originalUrl(redirectionCreateRequest.getOriginalUrl())
       .build();

      return redirectionRepository.save(redirection);
  }
}
