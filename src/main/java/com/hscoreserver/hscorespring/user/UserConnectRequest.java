package com.hscoreserver.hscorespring.user;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserConnectRequest {

  @NotEmpty
  private String maleToken; // 친구 id

  @NotEmpty
  private String femaleToken; // 내 id
}
