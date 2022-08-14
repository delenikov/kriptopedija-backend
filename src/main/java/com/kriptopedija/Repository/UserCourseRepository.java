package com.kriptopedija.Repository;

import com.kriptopedija.Models.User;
import com.kriptopedija.Models.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse, User> {
    Optional<UserCourse> findByUser_NameAndCourse_Id(String username, Long Id);
}