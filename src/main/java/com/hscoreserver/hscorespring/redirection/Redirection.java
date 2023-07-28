package com.hscoreserver.hscorespring.redirection;

import com.hscoreserver.hscorespring.common.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "redirections")
public class Redirection extends BaseTimeEntity {

  @Id
  @Column(columnDefinition = "VARCHAR(10)", unique = true, nullable = false, name = "token")
  private String token;

  private String originalUrl;

  private String shortUrl;

  public Redirection(String originalUrl, String baseUrl, String token) {
    this.originalUrl = originalUrl;
    this.token = token;
    this.shortUrl = baseUrl + "/" + token;
  }
}
