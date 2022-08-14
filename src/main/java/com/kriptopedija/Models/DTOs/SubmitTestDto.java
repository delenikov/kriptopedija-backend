package com.kriptopedija.Models.DTOs;

import com.kriptopedija.Models.Answer;
import lombok.Data;

import java.util.List;

@Data
public class SubmitTestDto {
    List<Answer> answers;
}
