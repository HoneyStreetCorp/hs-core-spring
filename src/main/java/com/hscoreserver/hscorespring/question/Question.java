package com.hscoreserver.hscorespring.question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Entity
@Getter
public class Question {

  @Id
  @GeneratedValue
  @Column(name = "question_id", nullable = false, columnDefinition = "BINARY(16)")
  private UUID id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "body")
  private String body;

  @Enumerated(EnumType.STRING)
  @Column(name = "category")
  private Category category;

  @Builder
  protected Question(String title, String body, Category category) {
    this.title = title;
    this.body = body;
    this.category = category;
  }
}
