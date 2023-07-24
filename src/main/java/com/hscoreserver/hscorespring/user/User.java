package com.hscoreserver.hscorespring.user;

import com.hscoreserver.hscorespring.common.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Random;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "users")
public class User extends BaseTimeEntity implements Serializable {

  private static final int TOKEN_LENGTH = 6;

  @Id
  @GeneratedValue
  @Column(name = "user_id", nullable = false, columnDefinition = "BINARY(16)")
  private UUID userId;

  private String name;

  private String token;

  public User(String name) {
    this.token = generateBase62();
    this.name = name + "#" + token;
  }

  private String generateBase62() {
    String charArr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < TOKEN_LENGTH; i++) {
      Random rand = new Random();
      int index = rand.nextInt(62);
      res.append(charArr.charAt(index));
    }
    return res.toString();
  }
}
