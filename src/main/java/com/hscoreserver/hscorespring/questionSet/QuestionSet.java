package com.hscoreserver.hscorespring.questionSet;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class QuestionSet {

  @Id
  @GeneratedValue
  private Long id;

  @Enumerated(EnumType.STRING)
  private QuestionSetName name;

  private BigDecimal count;
}
