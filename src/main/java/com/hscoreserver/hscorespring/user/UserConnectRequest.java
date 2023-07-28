package com.hscoreserver.hscorespring.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserConnectRequest {

  private String maleToken;
  private String femaleToken;
}
