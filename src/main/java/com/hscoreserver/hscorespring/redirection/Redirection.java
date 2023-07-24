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

  public Redirection(String originalUrl) {
    this.originalUrl = originalUrl;
    this.token = Base62Util.generateBase62();
  }
}
