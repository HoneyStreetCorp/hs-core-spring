package com.hscoreserver.hscorespring.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import com.hscoreserver.hscorespring.error.exception.NotFoundException;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

  private static final String EXISTS_TOKEN = "exists token";
  private static final String NOT_EXISTS_TOKEN = "not exists token";

  private final UserRepository userRepository = mock(UserRepository.class);

  private UserService userService;

  @BeforeEach
  void setUp() {
    userService = new UserService(userRepository);

    // save
    given(userRepository.save(any(User.class))).will(invocation -> invocation.getArgument(0));

    // get
    given(userRepository.findByToken(eq(EXISTS_TOKEN))).willReturn(Optional.of(new User()));
  }

  @Test
  void createUser() {
    // given
    String name = "name";

    // when
    User user = userService.createUser(name);

    // then
    assertThat(user.getUsername()).contains(name);
  }

  @Test
  void getUserWhenTokenExists() {
    User user = userService.getUser(EXISTS_TOKEN);

    assertThat(user).isNotNull();
  }

  @Test
  void getUserWhenTokenNotExists() {
    assertThatThrownBy(() -> userService.getUser(NOT_EXISTS_TOKEN))
        .isInstanceOf(NotFoundException.class);
  }
}
