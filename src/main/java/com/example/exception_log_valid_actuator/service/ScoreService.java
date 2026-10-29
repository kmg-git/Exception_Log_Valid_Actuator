package com.example.exception_log_valid_actuator.service;

import com.example.exception_log_valid_actuator.Repository.ScoreRepository;
import com.example.exception_log_valid_actuator.Repository.StudentRepository;
import com.example.exception_log_valid_actuator.domain.Score;
import com.example.exception_log_valid_actuator.dto.request.ScoreLineRequest;
import com.example.exception_log_valid_actuator.exception.DuplicateSubjectException;
import com.example.exception_log_valid_actuator.exception.StudentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private final StudentRepository studentRepository;
    private final ScoreRepository scoreRepository;

    public String register(Long studentId, List<ScoreLineRequest> scores) {

        studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException());

        for (ScoreLineRequest line : scores) {
            if(scoreRepository.exists(studentId, line.getSubject())){
                throw new DuplicateSubjectException();
            }
            scoreRepository.save(studentId, line.getSubject(), line.getScore());
        }

        return scores.size() + "개 과목의 성적이 등록되었습니다";
    }

    public List<Score> getScores(Long studentId) {
        return scoreRepository.findByStudentId(studentId);
    }
}