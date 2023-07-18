package com.hscoreserver.hscorespring.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue
  private UUID userId;
  private String name;
  private String token;

  @CreatedDate
  private LocalDateTime createdAt;

  // TODO(해시코드 생성 코드 구현 및 내려주는 값 변경 @hoo)
  public User(String name, LocalDateTime createdAt) {
    this.name = name;
    this.createdAt = createdAt;
  }
}
