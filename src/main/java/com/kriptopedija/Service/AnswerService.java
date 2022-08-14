package com.kriptopedija.Service;

import com.kriptopedija.Models.Answer;

import java.util.List;
import java.util.Optional;

public interface AnswerService {
    Optional<Answer> save(Answer answer);
    Optional<Answer> findById(Long id);
    List<Answer> findAll();
}
