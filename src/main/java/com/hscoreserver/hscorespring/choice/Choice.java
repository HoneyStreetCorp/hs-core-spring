package com.hscoreserver.hscorespring.choice;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Table(name = "choices")
public class Choice {

  @Id
  @GeneratedValue
  @Column(name = "choice_id", nullable = false, columnDefinition = "BINARY(16)")
  private UUID id;

  @Column(name = "question_id", nullable = false, columnDefinition = "BINARY(16)")
  private UUID questionId;

  @Column(name = "number", nullable = false)
  private String number;

  @Column(name = "content", nullable = false)
  private String content;
}
