package com.kriptopedija.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String answerText;

    @JsonIgnore
    private boolean isCorrect;

    @JsonIgnore
    @ManyToOne
    private Question question;

    public Answer(Long id, String answerText, boolean isCorrect) {
        this.id = id;
        this.answerText = answerText;
        this.isCorrect = isCorrect;
    }

    public Answer() {
    }
}
