package com.example.exception_log_valid_actuator.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ScoreRequest {

    private Long studentId;
    private List<ScoreLineRequest> scores;
}