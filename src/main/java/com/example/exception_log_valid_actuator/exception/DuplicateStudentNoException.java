package com.example.exception_log_valid_actuator.exception;

public class DuplicateStudentNoException extends BaseException {
    public DuplicateStudentNoException() {

        super(ErrorCode.DUPLICATE_STUDENT_NO);
    }
}
