package com.kriptopedija.Service;

import com.kriptopedija.Models.Test;

import java.util.Optional;

public interface TestService {
    Optional<Test> findTestByCourseId(Long id);
    Optional<Test> save(Test test);
}
