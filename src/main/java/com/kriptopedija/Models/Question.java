package com.kriptopedija.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questionText;

    @OneToMany(mappedBy = "question")
    List<Answer> answers;

    @JsonIgnore
    @ManyToOne
    private Test test;

    public Question(Long id, String questionText) {
        this.id = id;
        this.questionText = questionText;
    }

    public Question() {
    }
}
