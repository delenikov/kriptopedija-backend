package com.kriptopedija.Service.Implementation;

import com.kriptopedija.Exceptions.CourseNotFoundException;
import com.kriptopedija.Exceptions.UserNotFoundException;
import com.kriptopedija.Models.Course;
import com.kriptopedija.Models.DTOs.CourseUserDto;
import com.kriptopedija.Models.User;
import com.kriptopedija.Models.UserCourse;
import com.kriptopedija.Repository.CourseRepository;
import com.kriptopedija.Repository.UserCourseRepository;
import com.kriptopedija.Repository.UserRepository;
import com.kriptopedija.Service.UserCourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserCourseServiceImpl implements UserCourseService {

    UserRepository userRepository;
    CourseRepository courseRepository;
    UserCourseRepository userCourseRepository;

    @Override
    public Optional<UserCourse> save(CourseUserDto courseUserDto) {
        User user = this.userRepository
                .findByUsername(courseUserDto.getUsername())
                .orElseThrow(() -> new UserNotFoundException(courseUserDto.getUsername()));
        Course course = this.courseRepository
                .findByName(courseUserDto.getName())
                .orElseThrow(() -> new CourseNotFoundException(courseUserDto.getName()));
        UserCourse userCourse = new UserCourse (user, course);
        userCourseRepository.save(userCourse);
        return Optional.of(userCourse);
    }

    @Override
    public Optional<UserCourse> addUserPointsForCourse(CourseUserDto courseUserDto, Double points) {
        User user = this.userRepository
                .findByUsername(courseUserDto.getUsername())
                .orElseThrow(() -> new UserNotFoundException(courseUserDto.getUsername()));
        Course course = this.courseRepository
                .findByName(courseUserDto.getName())
                .orElseThrow(() -> new CourseNotFoundException(courseUserDto.getName()));
        UserCourse userCourse = userCourseRepository.findByUser_NameAndCourse_Id(user.getName(), course.getId()).get();
        userCourse.setPoints(points);
        userCourseRepository.save(userCourse);
        return Optional.of(userCourse);
    }
}
