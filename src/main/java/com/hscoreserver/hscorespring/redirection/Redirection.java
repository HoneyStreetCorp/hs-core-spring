package com.hscoreserver.hscorespring.redirection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "redirections")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Redirection {

  @Id
  private String token;

  private String originalUrl;
}
