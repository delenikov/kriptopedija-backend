package com.kriptopedija.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String videoURL;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<UserCourse> userCourses;

    @JsonIgnore
    @OneToOne(mappedBy = "course", fetch = FetchType.EAGER)
    private Test test;

    public Course(Long id, String name, String videoURL) {
        this.id = id;
        this.name = name;
        this.videoURL = videoURL;
    }

    public Course() {
    }

}
