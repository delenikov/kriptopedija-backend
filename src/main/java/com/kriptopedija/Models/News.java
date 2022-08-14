package com.kriptopedija.Models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Clob;
import java.time.LocalDate;

@Data
@Entity
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;
    private String description;

    //@Column(columnDefinition = "TEXT")
    @Lob
    @Column(name = "DATA", columnDefinition = "BLOB", nullable = false)
    private String text;
    private LocalDate date;

    public News(String name, String description, String text) {
        this.name = name;
        this.description = description;
        this.text = text;
        this.date = LocalDate.now();
    }

    public News() {
    }
}
