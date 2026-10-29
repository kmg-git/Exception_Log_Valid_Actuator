package com.example.exception_log_valid_actuator.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Score {

    private Long id;
    private Long studentId;
    private String subject;
    private int score;
}