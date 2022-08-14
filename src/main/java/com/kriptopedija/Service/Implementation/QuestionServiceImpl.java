package com.kriptopedija.Service.Implementation;

import com.kriptopedija.Models.Question;
import com.kriptopedija.Repository.QuestionRepository;
import com.kriptopedija.Service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public Optional<Question> save(Question question) {
        questionRepository.save(question);
        return Optional.of(question);
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }
}
