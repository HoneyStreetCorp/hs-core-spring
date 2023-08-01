package com.hscoreserver.hscorespring.user;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.hscoreserver.hscorespring.error.exception.SystemException;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserController.class)
class UserControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private UserService userService;

  @Nested
  @DisplayName("POST /api/v1/users")
  class Describe_createUser {

    @Nested
    @DisplayName("name 이 있을 때")
    class Context_when_name_exists {

      @BeforeEach
      void setUp() {
        given(userService.createUser(any(String.class))).will(invocation -> {
              String name = invocation.getArgument(0);
              User user = new User(name);
              user.setId(UUID.randomUUID());
              return user;
            }
        );
      }

      @Test
      void It_responds_user_and_201() throws Exception {
        mvc.perform((post(buildURIPath()))
                .param("name", "test")
            )
            .andExpect(status().isCreated());
      }
    }

    @Nested
    @DisplayName("name 이 없을 때")
    class Context_when_name_not_exists {

      @Test
      void It_responds_400() throws Exception {
        mvc.perform((post(buildURIPath()))
            )
            .andExpect(status().isBadRequest());
      }
    }
  }

  @Nested
  @DisplayName("GET /api/v1/users/connect")
  class Describe_connectUser {

    @Nested
    @DisplayName("maleToken과 femaleToken이 주어지면")
    class Context_with_valid_request {

      @BeforeEach
      void setUp() {
        given(userService.connectUser(any(UserConnectRequest.class))).will(invocation -> {
          UserConnectRequest request = invocation.getArgument(0);
          User user = new User("test");
          user.setId(UUID.randomUUID());
          return user;
        });
      }

      @Test
      @DisplayName("200 OK를 응답한다")
      void it_responds_200_ok() throws Exception {
        mvc.perform(post(buildURIPath("connect"))
                .param("maleToken", "test")
                .param("femaleToken", "test")
            )
            .andExpect(status().isOk());
      }
    }

    @Nested
    @DisplayName("maleToken과 femaleToken이 주어지지 않으면")
    class Context_with_invalid_request {

      @Test
      @DisplayName("400 Bad Request를 응답한다")
      void it_responds_400_bad_request() throws Exception {
        mvc.perform(post(buildURIPath("connect"))
            )
            .andExpect(status().isBadRequest());
      }
    }

    @Nested
    @DisplayName("maleToken과 femaleToken이 같으면")
    class Context_with_same_token {

      @BeforeEach
      void setUp() {
        given(userService.connectUser(any(UserConnectRequest.class))).willThrow(
            new SystemException("error", HttpStatus.BAD_REQUEST));
      }

      @Test
      @DisplayName("400 Bad Request를 응답한다")
      void it_responds_400_bad_request() throws Exception {
        mvc.perform(post(buildURIPath("connect"))
                .param("maleToken", "test")
                .param("femaleToken", "test")
            )
            .andExpect(status().isBadRequest());
      }
    }

    @Nested
    @DisplayName("maleToken과 femaleToken이 존재하지 않는 토큰이면")
    class Context_with_not_exist_token {

      @BeforeEach
      void setUp() {
        given(userService.connectUser(any(UserConnectRequest.class))).willThrow(
            new SystemException("error", HttpStatus.NOT_FOUND));
      }

      @Test
      @DisplayName("404 Not Found를 응답한다")
      void it_responds_400_bad_request() throws Exception {
        mvc.perform(post(buildURIPath("connect"))
                .param("maleToken", "test")
                .param("femaleToken", "test")
            )
            .andExpect(status().isNotFound());
      }
    }
  }

  private String buildURIPath(String path) {
    return "/api/v1/users/" + path;
  }

  private String buildURIPath() {
    return "/api/v1/users";
  }
}
