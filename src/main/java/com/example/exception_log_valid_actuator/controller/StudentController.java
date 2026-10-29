package com.example.exception_log_valid_actuator.controller;

import com.example.exception_log_valid_actuator.domain.Score;
import com.example.exception_log_valid_actuator.domain.Student;
import com.example.exception_log_valid_actuator.dto.request.StudentRequest;
import com.example.exception_log_valid_actuator.service.ScoreService;
import com.example.exception_log_valid_actuator.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final ScoreService scoreService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student register(@RequestBody StudentRequest request) {
        return studentService.register(request.getStudentNo(), request.getName());
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/{id}/scores")
    public List<Score> scores(@PathVariable Long id) {
        return scoreService.getScores(id);
    }
}