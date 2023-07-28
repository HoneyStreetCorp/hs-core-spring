package com.hscoreserver.hscorespring.redirection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import com.hscoreserver.hscorespring.common.HsConfig;
import com.hscoreserver.hscorespring.error.exception.NotFoundException;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(HsConfig.class)
@SpringBootTest
class RedirectionServiceTest {

  private static final String ORIGINAL_URL = "https://www.hscore.co.kr";
  private static final String EXISTS_TOKEN = "exists";
  private static final String NOT_EXISTS_TOKEN = "not_exists";

  private final RedirectionRepository redirectionRepository = mock(RedirectionRepository.class);

  @Autowired
  private HsConfig hsConfig;

  private RedirectionService redirectionService;

  @BeforeEach
  void setUp() {
    redirectionService = new RedirectionService(
        hsConfig,
        redirectionRepository
    );

    // 저장
    given(redirectionRepository.save(any())).will(invocation -> invocation.getArgument(0));

    // 조회
    given(redirectionRepository.findById(eq(EXISTS_TOKEN)))
        .willReturn(
            Optional.of(new Redirection(ORIGINAL_URL, hsConfig.getBaseUrl(), EXISTS_TOKEN)));
  }

  @Test
  @DisplayName("create 메서드 테스트")
  void createRedirection() {
    RedirectionCreateRequest request = RedirectionCreateRequest.builder()
        .originalUrl(ORIGINAL_URL)
        .build();

    // when
    Redirection redirection = redirectionService.create(request);

    // then
    assertThat(redirection.getToken()).isNotNull();
    assertThat(redirection.getOriginalUrl()).isEqualTo(ORIGINAL_URL);
    assertThat(redirection.getShortUrl())
        .isEqualTo(buildShortUrl(hsConfig.getBaseUrl(), redirection.getToken()));
  }

  @Test
  @DisplayName("getRedirection 정상 동작 테스트")
  void getRedirection() {
    Redirection redirection = redirectionService.getRedirection(EXISTS_TOKEN);

    assertThat(redirection.getToken()).isEqualTo(EXISTS_TOKEN);
    assertThat(redirection.getOriginalUrl()).isEqualTo(ORIGINAL_URL);
    assertThat(redirection.getShortUrl())
        .isEqualTo(buildShortUrl(hsConfig.getBaseUrl(), EXISTS_TOKEN));
  }

  @Test
  @DisplayName("getRedirection 실패 테스트")
  void getRedirectionFail() {
    assertThatThrownBy(() -> redirectionService.getRedirection(NOT_EXISTS_TOKEN))
        .isInstanceOf(NotFoundException.class);
  }

  private String buildShortUrl(String baseUrl, String token) {
    return baseUrl + "/" + token;
  }

}

