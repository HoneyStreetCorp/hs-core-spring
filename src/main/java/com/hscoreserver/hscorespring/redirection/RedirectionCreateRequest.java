package com.hscoreserver.hscorespring.redirection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RedirectionCreateRequest {
  private String originalUrl;
}
