package com.example.exception_log_valid_actuator.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudentRequest {

    @NotBlank
    @Pattern(regexp = "[0-9]{5}-[0-9]{3}")
    private String studentNo;

    @NotBlank
    private String name;
}