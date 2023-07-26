package com.hscoreserver.hscorespring.question;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {

  private final QuestionRepository questionRepository;

  public Page<Question> get(Category category, Pageable pageable) {
    return questionRepository.findByCategory(category, pageable);
  }
}
