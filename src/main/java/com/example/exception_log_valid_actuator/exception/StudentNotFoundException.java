package com.example.exception_log_valid_actuator.exception;

public class StudentNotFoundException extends BaseException {
    public StudentNotFoundException() {

        super(ErrorCode.STUDENT_NOT_FOUND);
    }
}
