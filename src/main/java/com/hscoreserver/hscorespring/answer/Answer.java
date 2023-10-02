package com.hscoreserver.hscorespring.answer;

import com.hscoreserver.hscorespring.choice.Choice;
import com.hscoreserver.hscorespring.question.Question;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Entity
public class Answer {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  private Question question;

  @ManyToOne
  private Choice choice;

  private String answer;
}
