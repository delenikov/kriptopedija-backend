package com.kriptopedija.Service;

import com.kriptopedija.Models.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    Optional<Question> save (Question question);
    Optional<Question> findById (Long id);
    List<Question> findAll();
}
