package com.example.exception_log_valid_actuator.Repository;

import com.example.exception_log_valid_actuator.domain.Score;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ScoreRepository {

    private final Map<Long, Score> store = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong();

    public Score save(Long studentId, String subject, int score) {
        Long id = sequence.incrementAndGet();
        Score saved = new Score(id, studentId, subject, score);
        store.put(id, saved);
        return saved;
    }

    public List<Score> findByStudentId(Long studentId) {
        return store.values().stream()
                .filter(s -> s.getStudentId().equals(studentId))
                .toList();
    }

    public boolean exists(Long studentId, String subject) {
        return store.values().stream()
                .anyMatch(s -> s.getStudentId().equals(studentId)
                        && s.getSubject().equals(subject));
    }
}