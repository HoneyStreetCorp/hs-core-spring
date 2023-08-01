package com.hscoreserver.hscorespring.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;

  @Test
  @DisplayName("토큰이 존재할 때")
  void whenTokenExists() {
    // given
    User user = new User("name");
    userRepository.save(user);

    // when
    User found = userRepository.findByToken(user.getToken()).get();

    // then
    assertThat(user).isEqualTo(found);
  }

  @Test
  @DisplayName("토큰이 존재하지 않을 때")
  void whenTokenNotExists() {
    Optional<User> notExists = userRepository.findByToken("not exists");

    assertThat(notExists).isEmpty();
  }

  @Test
  @DisplayName("save 테스트")
  void save() {
    // given
    User user = new User("name");

    // when
    User saved = userRepository.save(user);

    // then
    assertThat(saved).isEqualTo(user);
  }
}
