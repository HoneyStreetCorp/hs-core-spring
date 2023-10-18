package com.hscoreserver.hscorespring.question;

import com.hscoreserver.hscorespring.choice.Choice;
import com.hscoreserver.hscorespring.questionSet.QuestionSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
  private Question(String title, String body, Category category, QuestionSet questionSet) {
    this.title = title;
    this.body = body;
    this.category = category;
    this.questionSet = questionSet;
  }

  @ManyToOne
  @JoinColumn(name = "question_set_id")
  private QuestionSet questionSet;

  @OneToMany(mappedBy = "question")
  private List<Choice> choices = new ArrayList<>();

  protected static Question createQuestion(QuestionCreateRequest request, QuestionSet questionSet) {
    return Question.builder()
        .title(request.getTitle())
        .body(request.getBody())
        .category(request.getCategory())
        .questionSet(questionSet)
        .build();
  }
}
