package com.example.exception_log_valid_actuator.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScoreLineRequest {

    private String subject;
    private int score;
}