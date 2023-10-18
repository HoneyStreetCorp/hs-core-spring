package com.hscoreserver.hscorespring.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserConnectRequest {
  private String maleToken;
  private String femaleToken;
}
