package com.hscoreserver.hscorespring.user;

import com.hscoreserver.hscorespring.common.BaseTimeEntity;
import com.hscoreserver.hscorespring.util.Base62Util;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(
    name = "users",
    indexes = @Index(name = "idx_token", columnList = "token", unique = true)
)
public class User extends BaseTimeEntity {

  @Id
  @GeneratedValue
  @Setter(value = AccessLevel.PROTECTED)
  @Column(name = "user_id", nullable = false, columnDefinition = "BINARY(16)")
  private UUID id;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "token", nullable = false, unique = true)
  private String token;

  @Setter(value = AccessLevel.PRIVATE)
  @Column(name = "friend_token", unique = true)
  private String friendToken;

  public User(String name) {
    this.token = Base62Util.generateBase62();
    this.username = name + "#" + token;
  }

  protected void connect(User female) {
    this.friendToken = female.token;
    female.setFriendToken(this.token);
  }
}
