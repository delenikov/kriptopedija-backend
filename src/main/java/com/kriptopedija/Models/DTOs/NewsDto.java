package com.kriptopedija.Models.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class NewsDto {

    private String name;
    private String description;
    private String text;
    private LocalDate date;

    public NewsDto(String name, String description, String text) {
        this.name = name;
        this.description = description;
        this.text = text;
        this.date = LocalDate.now();
    }
}
