package com.kriptopedija.Service.Implementation;

import com.kriptopedija.Models.Answer;
import com.kriptopedija.Repository.AnswerRepository;
import com.kriptopedija.Service.AnswerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    @Override
    public Optional<Answer> save(Answer answer) {
        answerRepository.delete(answer);
        answerRepository.save(answer);
        return Optional.of(answer);
    }

    @Override
    public Optional<Answer> findById(Long id) {
        return answerRepository.findById(id);
    }

    @Override
    public List<Answer> findAll() {
        return answerRepository.findAll();
    }
}
