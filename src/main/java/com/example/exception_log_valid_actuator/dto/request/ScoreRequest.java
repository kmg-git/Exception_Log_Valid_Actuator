package com.example.exception_log_valid_actuator.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ScoreRequest {
    @NotNull
    private Long studentId;

    @Valid
    @NotNull
    @NotEmpty
    private List<ScoreLineRequest> scores;
}