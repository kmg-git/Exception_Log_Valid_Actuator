package com.example.exception_log_valid_actuator.exception;

public abstract class BaseException extends RuntimeException {
    private final ErrorCode errorCode;

    protected BaseException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
