package com.hscoreserver.hscorespring.question;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionRepository extends JpaRepository<Question, Long> {

  @Query("select q from Question q where q.questionSetId = :id")
  List<Question> findByQuestionSet(@Param("id") Long id);
}
