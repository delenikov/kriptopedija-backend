package com.kriptopedija.Service.Implementation;

import com.kriptopedija.Models.Test;
import com.kriptopedija.Repository.TestRepository;
import com.kriptopedija.Service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor

public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    @Override
    public Optional<Test> findTestByCourseId(Long id) {
        return testRepository.findByCourse_Id(id);
    }

    @Override
    public Optional<Test> save(Test test) {
        testRepository.save(test);
        return Optional.of(test);
    }
}
