package com.hscoreserver.hscorespring.redirection;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.hscoreserver.hscorespring.common.HsConfig;
import com.hscoreserver.hscorespring.error.exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@Import(HsConfig.class)
@WebMvcTest(RedirectionController.class)
class RedirectionControllerTest {

  private static final String ORIGINAL_URL = "https://www.hscore.co.kr";
  private static final String EXISTS_TOKEN = "exists";
  private static final String NOT_EXISTS_TOKEN = "notexists";

  @Autowired
  private MockMvc mvc;

  @Autowired
  private HsConfig config;

  @MockBean
  private RedirectionService redirectionService;

  @BeforeEach
  void setUp() {

  }

  @Nested
  @DisplayName("POST /redirections")
  class Describe_createRedirection {

    @Nested
    @DisplayName("URL이 올바른 RedirectionCreateRequest가 주어지면")
    class Context_with_valid_request {

      @BeforeEach
      void setUp() {
        given(redirectionService.create(any())).will(invocation -> {
          RedirectionCreateRequest request = invocation.getArgument(0);
          return new Redirection(request.getOriginalUrl(), config.getBaseUrl(), EXISTS_TOKEN);
        });
      }

      @Test
      @DisplayName("201 Created를 응답한다")
      void it_responds_201_created() throws Exception {
        mvc.perform(post(buildURIPath())
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.format("{\"originalUrl\": \"%s\"}", ORIGINAL_URL)))
            .andExpect(status().isCreated())
            .andExpect(content()
                .string(
                    "{\"originalUrl\":\"https://www.hscore.co.kr\","
                        + "\"shortUrl\":\"http://localhost:8080/exists\"}"
                )
            );
      }
    }

    @Nested
    @DisplayName("URL이 올바르지 않은 RedirectionCreateRequest가 주어지면")
    class Context_with_invalid_request {

      @Test
      @DisplayName("400 Bad Request를 응답한다")
      void it_responds_400_bad_request() throws Exception {
        mvc.perform(post(buildURIPath())
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"originalUrl\":\"\"}"))
            .andExpect(status().isBadRequest());
      }
    }
  }

  @Nested
  @DisplayName("GET /redirections/{token}")
  class Describe_getRedirection {

    @Nested
    @DisplayName("존재하는 토큰이 주어지면")
    class Context_with_exists_token {

      @BeforeEach
      void setUp() {
        given(redirectionService.getRedirection(EXISTS_TOKEN)).willReturn(
            new Redirection(ORIGINAL_URL, config.getBaseUrl(), EXISTS_TOKEN)
        );
      }

      @Test
      @DisplayName("307 Temporary_Redirect를 응답한다")
      void it_responds_307_temporary_redirect() throws Exception {
        mvc.perform(get(buildURIPath(EXISTS_TOKEN)))
            .andExpect(status().isTemporaryRedirect());
      }
    }

    @Nested
    @DisplayName("존재하지 않는 토큰이 주어지면")
    class Context_with_not_exists_token {

      @BeforeEach
      void setUp() {
        given(redirectionService.getRedirection(NOT_EXISTS_TOKEN)).willThrow(
            NotFoundException.class);
      }

      @Test
      @DisplayName("404 Not Found를 응답한다")
      void it_responds_404_not_found() throws Exception {
        mvc.perform(get(buildURIPath(NOT_EXISTS_TOKEN)))
            .andExpect(status().isNotFound());
      }
    }
  }

  private String buildURIPath(String path) {
    return "/api/v1/redirections/" + path;
  }

  private String buildURIPath() {
    return "/api/v1/redirections";
  }
}
