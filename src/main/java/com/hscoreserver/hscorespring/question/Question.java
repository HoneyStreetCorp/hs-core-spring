package com.hscoreserver.hscorespring.question;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Entity
@Getter
@Table(name = "questions")
public class Question {

  @Id
  @GeneratedValue
  @Column(name = "question_id")
  private Long id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "body")
  private String body;

  @Enumerated(EnumType.STRING)
  @Column(name = "category")
  private Category category;

  @Builder
  private Question(String title, String body, Category category, Long questionSetId) {
    this.title = title;
    this.body = body;
    this.category = category;
    this.questionSetId = questionSetId;
  }

  private Long questionSetId;

  protected static Question createQuestion(QuestionCreateRequest request) {
    return Question.builder()
        .title(request.getTitle())
        .body(request.getBody())
        .category(request.getCategory())
        .questionSetId(request.getQuestionSetId())
        .build();
  }
}
