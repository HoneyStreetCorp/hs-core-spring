package com.hscoreserver.hscorespring.user;

import com.hscoreserver.hscorespring.common.BaseTimeEntity;
import com.hscoreserver.hscorespring.util.Base62Util;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;

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
  @Column(name = "user_id", nullable = false, columnDefinition = "BINARY(16)")
  private UUID id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "token", nullable = false, unique = true)
  private String token;

  @Setter(value = AccessLevel.PRIVATE)
  @Column(name = "friend_token", unique = true)
  private String friendToken;

  public User(String name) {
    this.token = Base62Util.generateBase62();
    this.name = name + "#" + token;
  }

  protected void connect(User female) {
    this.friendToken = female.token;
    female.setFriendToken(this.token);
  }
}
