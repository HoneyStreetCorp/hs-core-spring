package com.hscoreserver.hscorespring.user;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

  private final UserService userService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public UserResponse createUser(@RequestParam String name) {
    User user = userService.createUser(name);
    return new UserResponse(user);
  }

  @PostMapping("/connect")
  @ResponseStatus(HttpStatus.OK)
  public UserResponse connectUser(@Valid UserConnectRequest connectRequest) {
    User male = userService.connectUser(connectRequest);
    return new UserResponse(male);
  }
}
