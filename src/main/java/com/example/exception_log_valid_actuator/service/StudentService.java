package com.example.exception_log_valid_actuator.service;

import com.example.exception_log_valid_actuator.Repository.StudentRepository;
import com.example.exception_log_valid_actuator.domain.Student;
import com.example.exception_log_valid_actuator.exception.DuplicateStudentNoException;
import com.example.exception_log_valid_actuator.exception.StudentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student register(String studentNo, String name) {
        if(studentRepository.existsByStudentNo(studentNo)){
            throw new DuplicateStudentNoException();
        }
        return studentRepository.save(studentNo, name);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException());
    }
}