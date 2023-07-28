package com.hscoreserver.hscorespring.redirection;

import com.hscoreserver.hscorespring.common.HsConfig;
import com.hscoreserver.hscorespring.error.ErrorCode;
import com.hscoreserver.hscorespring.error.exception.NotFoundException;
import com.hscoreserver.hscorespring.util.Base62Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedirectionService {

  private final HsConfig config;
  private final RedirectionRepository redirectionRepository;

  public Redirection create(RedirectionCreateRequest request) {
    Redirection redirection = new Redirection(
        request.getOriginalUrl(),
        config.getBaseUrl(),
        Base62Util.generateBase62()
    );
    return redirectionRepository.save(redirection);
  }

  // TODO: 없을 때 not found exception 하는게 맞는지
  public Redirection getRedirection(String token) {
    return redirectionRepository.findById(token)
        .orElseThrow(() -> new NotFoundException(ErrorCode.REDIRECTION_NOT_FOUND,
            String.format("token: %s", token))
        );
  }
}
