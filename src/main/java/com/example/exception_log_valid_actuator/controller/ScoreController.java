package com.example.exception_log_valid_actuator.controller;

import com.example.exception_log_valid_actuator.dto.request.ScoreRequest;
import com.example.exception_log_valid_actuator.service.ScoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/scores")
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreService scoreService;

    @PostMapping
    public Map<String, String> register(@Valid @RequestBody ScoreRequest request) {
        return Map.of("message",
                scoreService.register(request.getStudentId(), request.getScores()));
    }
}