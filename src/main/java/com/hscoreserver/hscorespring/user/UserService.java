package com.hscoreserver.hscorespring.user;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public User createUser(String name) {
    User user = new User(name);
    return userRepository.save(user);
  }
}
