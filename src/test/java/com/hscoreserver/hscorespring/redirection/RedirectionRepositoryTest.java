package com.hscoreserver.hscorespring.redirection;

import static org.assertj.core.api.Assertions.assertThat;

import com.hscoreserver.hscorespring.common.HsConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@Import(HsConfig.class)
@ExtendWith(SpringExtension.class)
class RedirectionRepositoryTest {

  private static final String ORIGINAL_URL = "https://www.hscore.co.kr";
  private static final String NOT_EXISTED_TOKEN = "not_existed_token";
  private static final String TOKEN = "token";

  @Autowired
  private HsConfig config;

  @Autowired
  private RedirectionRepository redirectionRepository;

  @Test
  @DisplayName("Redirection 저장")
  void saveRedirection() {
    Redirection redirection = new Redirection(ORIGINAL_URL, config.getBaseUrl(), TOKEN);
    redirectionRepository.save(redirection);

    assertThat(redirection.getToken()).isNotNull();
    assertThat(redirection.getOriginalUrl()).isEqualTo(ORIGINAL_URL);
    assertThat(redirection.getShortUrl()).contains(config.getBaseUrl());
  }

  @Test
  @DisplayName("Redirection 정상 조회")
  void findRedirection() {
    Redirection redirection = new Redirection(ORIGINAL_URL, config.getBaseUrl(), TOKEN);
    redirectionRepository.save(redirection);

    Redirection findRedirection = redirectionRepository.findById(redirection.getToken()).get();

    assertThat(findRedirection.getToken()).isEqualTo(redirection.getToken());
    assertThat(findRedirection.getOriginalUrl()).isEqualTo(redirection.getOriginalUrl());
    assertThat(findRedirection.getShortUrl()).isEqualTo(redirection.getShortUrl());
  }

  @Test
  @DisplayName("Redirection 조회 실패")
  void findRedirectionFail() {
    Redirection redirection = new Redirection(ORIGINAL_URL, config.getBaseUrl(), TOKEN);
    redirectionRepository.save(redirection);

    assertThat(redirectionRepository.findById(NOT_EXISTED_TOKEN)).isEmpty();
  }
}
