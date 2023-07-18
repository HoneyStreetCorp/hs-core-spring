package com.hscoreserver.hscorespring.user;

import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public User createUser(String name) {
    User user = new User(name, LocalDateTime.now());
    return userRepository.save(user);
  }
}
