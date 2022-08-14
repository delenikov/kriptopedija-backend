package com.kriptopedija.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "test", fetch = FetchType.EAGER)
    List<Question> questions;

    @JsonIgnore
    @OneToOne
    private Course course;

    public Test(String name) {
        this.id = id;
        this.name = name;
    }

    public Test() {
    }
}
