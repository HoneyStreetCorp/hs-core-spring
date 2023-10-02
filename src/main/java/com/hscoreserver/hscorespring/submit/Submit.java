package com.hscoreserver.hscorespring.submit;


import com.hscoreserver.hscorespring.answer.Answer;
import com.hscoreserver.hscorespring.choice.Choice;
import com.hscoreserver.hscorespring.question.Question;
import com.hscoreserver.hscorespring.user.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "submits")
public class Submit {

  @Id
  @GeneratedValue
  @Column(name = "submit_id")
  private Long id;

  @ManyToOne
  private Question question;

  @ManyToOne
  private Choice choice;

  @ManyToOne(optional = true)
  private Answer answer;

  @ManyToOne
  private User user;
}
