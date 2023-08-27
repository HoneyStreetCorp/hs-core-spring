package com.hscoreserver.hscorespring.questionSet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionSetRepository extends JpaRepository<QuestionSet, Long>{

  QuestionSet findByName(QuestionSetName name);
}
