package com.kriptopedija.Service.Implementation;

import com.kriptopedija.Models.Course;
import com.kriptopedija.Repository.CourseRepository;
import com.kriptopedija.Service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findByName(String courseName) {
        return courseRepository.findByName(courseName);
    }

    @Override
    public Optional<Course> findById(Long Id) {
        return courseRepository.findById(Id);
    }

    @Override
    public Optional<Course> save(Course course) {
        if(courseRepository.existsById(course.getId())){
            courseRepository.deleteById(course.getId());
        }
        courseRepository.save(course);
        return Optional.of(course);
    }


    @Override
    public void deleteById(Long Id) {
        courseRepository.deleteById(Id);
    }
}
