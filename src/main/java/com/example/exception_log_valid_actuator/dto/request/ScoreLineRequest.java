package com.example.exception_log_valid_actuator.dto.request;

import com.example.exception_log_valid_actuator.validation.AllowedSubject;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Getter
@NoArgsConstructor
public class ScoreLineRequest {

    @AllowedSubject
    @NotBlank
    private String subject;

    @NotNull
    @Range(min = 0, max = 100, message = "0~100 사이여야 합니다.")
    private Integer score;
}