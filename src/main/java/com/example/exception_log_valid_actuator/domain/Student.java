package com.example.exception_log_valid_actuator.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {

    private Long id;
    private String studentNo;   // 학번
    private String name;
}