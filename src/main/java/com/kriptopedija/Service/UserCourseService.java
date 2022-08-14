package com.kriptopedija.Service;

import com.kriptopedija.Models.DTOs.CourseUserDto;
import com.kriptopedija.Models.UserCourse;

import java.util.Optional;

public interface UserCourseService {
    Optional<UserCourse> save(CourseUserDto courseUserDto);
    Optional<UserCourse> addUserPointsForCourse(CourseUserDto courseUserDto, Double points);
}
