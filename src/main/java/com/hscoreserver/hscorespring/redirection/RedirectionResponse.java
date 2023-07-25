package com.hscoreserver.hscorespring.redirection;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RedirectionResponse {
  private String originalUrl;
  private String shortUrl;

  public RedirectionResponse(Redirection redirection) {
    this.originalUrl = redirection.getOriginalUrl();
    this.shortUrl = redirection.getShortUrl();
  }
}
