package com.hscoreserver.hscorespring.questionSet;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "question_sets")
public class QuestionSet {

  @Id
  @GeneratedValue
  @Column(name = "question_set_id")
  private Long id;

  private String name;

  private BigDecimal count;

  @Builder
  public QuestionSet(String name) {
    this.name = name;
    this.count = BigDecimal.ZERO;
  }
}
