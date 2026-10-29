package com.example.exception_log_valid_actuator.exception;

public class DuplicateSubjectException extends BaseException {
    public DuplicateSubjectException() {

        super(ErrorCode.DUPLICATE_SUBJECT);
    }
}
