package com.hscoreserver.hscorespring.susbmit;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "submits")
public class Submit {

  @Id
  @GeneratedValue
  @Column(name = "submit_id")
  private Long id;


  private Long questionId;

  private Long choiceId;

  @Nullable
  private Long answerId;
}
