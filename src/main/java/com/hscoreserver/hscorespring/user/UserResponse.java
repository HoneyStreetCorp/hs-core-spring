package com.hscoreserver.hscorespring.user;

import lombok.Getter;

@Getter
public class UserResponse {

  private final String id;
  private final String name;
  private final String token;

  public UserResponse(User user) {
    this.id = user.getId().toString();
    this.name = user.getName();
    this.token = user.getToken();
  }
}
