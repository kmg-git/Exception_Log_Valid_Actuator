package com.example.exception_log_valid_actuator.service;

import com.example.exception_log_valid_actuator.Repository.ScoreRepository;
import com.example.exception_log_valid_actuator.Repository.StudentRepository;
import com.example.exception_log_valid_actuator.domain.Score;
import com.example.exception_log_valid_actuator.dto.request.ScoreLineRequest;
import com.example.exception_log_valid_actuator.exception.DuplicateSubjectException;
import com.example.exception_log_valid_actuator.exception.StudentNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScoreService {

    private final StudentRepository studentRepository;
    private final ScoreRepository scoreRepository;

    public String register(Long studentId, List<ScoreLineRequest> scores) {
        log.info("과목 수 : " + scores.size() + "반복문 전");

        studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException());

        for (ScoreLineRequest line : scores) {
            if(scoreRepository.exists(studentId, line.getSubject())){
                throw new DuplicateSubjectException();
            }
            scoreRepository.save(studentId, line.getSubject(), line.getScore());
            log.info(line.getSubject() + " : " + line.getScore());
        }
        log.info("과목 수 : " + scores.size() + "반복문 후");
        log.debug("디버그 슛");

        return scores.size() + "개 과목의 성적이 등록되었습니다";
    }

    public List<Score> getScores(Long studentId) {
        return scoreRepository.findByStudentId(studentId);
    }
}