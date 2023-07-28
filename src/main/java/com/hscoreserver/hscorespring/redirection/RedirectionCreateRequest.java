package com.hscoreserver.hscorespring.redirection;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class RedirectionCreateRequest {

  @URL
  @NotEmpty
  private String originalUrl;

}
