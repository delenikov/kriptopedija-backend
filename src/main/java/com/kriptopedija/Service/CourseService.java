package com.kriptopedija.Service;

import com.kriptopedija.Models.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> findAll();
    Optional<Course> findByName(String courseName);
    Optional<Course> findById(Long Id);
    Optional<Course> save(Course course);
    void deleteById(Long Id);
}
