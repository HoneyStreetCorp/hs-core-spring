package com.hscoreserver.hscorespring.redirection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class RedirectionCreateRequest {

  private String originalUrl;

}
