package com.hscoreserver.hscorespring.choice;

import com.hscoreserver.hscorespring.common.model.BaseTimeEntity;
import com.hscoreserver.hscorespring.question.Question;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Table(name = "choices")
public class Choice extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "choice_id")
  private Long id;

  private int number;

  private String content;

  @ManyToOne
  @JoinColumn(name = "question_id")
  private Question question;

  @Builder
  public Choice(int number, String content, Question question) {
    this.number = number;
    this.content = content;
    this.question = question;
  }

  public static Choice createChoice(ChoiceCreateRequest request, Question question) {
    return Choice.builder()
        .number(request.getNumber())
        .content(request.getContent())
        .question(question)
        .build();
  }
}
