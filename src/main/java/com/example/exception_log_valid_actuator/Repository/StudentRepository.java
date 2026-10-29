package com.example.exception_log_valid_actuator.Repository;

import com.example.exception_log_valid_actuator.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class StudentRepository {

    private final Map<Long, Student> store = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong();

    public Student save(String studentNo, String name) {
        Long id = sequence.incrementAndGet();
        Student student = new Student(id, studentNo, name);
        store.put(id, student);
        return student;
    }

    public Optional<Student> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public boolean existsByStudentNo(String studentNo) {
        return store.values().stream()
                .anyMatch(s -> s.getStudentNo().equals(studentNo));
    }

    public int count() {
        return store.size();
    }
}