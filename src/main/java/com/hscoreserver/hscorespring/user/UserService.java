package com.hscoreserver.hscorespring.user;

import com.hscoreserver.hscorespring.error.ErrorCode;
import com.hscoreserver.hscorespring.error.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

  public User getUser(String token) {
    return userRepository.findByToken(token)
        .orElseThrow(() -> new NotFoundException(
            ErrorCode.USER_NOT_FOUND,
            String.format("token: %s", token))
        );
  }

  public User connectUser(UserConnectRequest request) {
    User male = getUser(request.getMaleToken());
    User female = getUser(request.getFemaleToken());

    male.connect(female);
    return male;
  }
}
