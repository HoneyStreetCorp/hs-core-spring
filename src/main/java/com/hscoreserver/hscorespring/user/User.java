package com.hscoreserver.hscorespring.user;

import com.hscoreserver.hscorespring.common.BaseTimeEntity;
import com.hscoreserver.hscorespring.util.Base62Util;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "users")
public class User extends BaseTimeEntity {

  @Id
  @GeneratedValue
  @Column(name = "user_id", nullable = false, columnDefinition = "BINARY(16)")
  private UUID userId;

  private String name;

  private String token;

  public User(String name) {
    this.token = Base62Util.generateBase62();
    this.name = name + "#" + token;
  }
}
