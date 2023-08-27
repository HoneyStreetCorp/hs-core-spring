package com.hscoreserver.hscorespring.susbmit;


import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Submit {

  @Id
  private String id;


  private String questionId;

  private String choiceId;

  @Nullable
  private String answer;
}
