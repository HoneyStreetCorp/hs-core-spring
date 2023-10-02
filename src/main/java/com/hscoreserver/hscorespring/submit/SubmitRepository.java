package com.hscoreserver.hscorespring.submit;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubmitRepository extends JpaRepository<Submit, Long> {

  @Query("select s from Submit s "
      + "left join fetch Question q "
      + "on s.question.id = q.id "
      + "left join fetch User u "
      + "on s.user.id = u.id"
  )
  List<Submit> findByQuestionIdAndUserId(
      @Param("questionId") Long questionId,
      @Param("userId") Long userId
  );
}
