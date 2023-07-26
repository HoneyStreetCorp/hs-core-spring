package com.hscoreserver.hscorespring.redirection;

import com.hscoreserver.hscorespring.common.BaseTimeEntity;
import com.hscoreserver.hscorespring.util.Base62Util;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "redirections")
public class Redirection extends BaseTimeEntity {

  @Id
  @Column(columnDefinition = "VARCHAR(10)", unique = true, nullable = false, name = "token")
  private String token;

  private String originalUrl;

  private String shortUrl;

  public Redirection(String originalUrl, String baseUrl) {
    this.originalUrl = originalUrl;
    this.token = Base62Util.generateBase62();
    this.shortUrl = baseUrl + "/" + token;
  }
}
