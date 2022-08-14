package com.kriptopedija.Models;

import com.kriptopedija.Models.IDs.UserCourseId;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@Data
@IdClass(UserCourseId.class)
public class UserCourse {

    @Id
    @ManyToOne
    User user;

    @Id
    @ManyToOne
    Course course;

    private Double points;

    public UserCourse(User user, Course course) {
        this.user = user;
        this.course = course;
    }

    public UserCourse() {
    }
}
