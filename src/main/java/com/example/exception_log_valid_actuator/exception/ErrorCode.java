package com.example.exception_log_valid_actuator.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    STUDENT_NOT_FOUND(HttpStatus.NOT_FOUND,"STU_001","학생을 찾을 수 없습니다."),
    DUPLICATE_STUDENT_NO(HttpStatus.CONFLICT, "STU_002","이미 사용 중인 학번입니다."),
    DUPLICATE_SUBJECT(HttpStatus.CONFLICT, "SCR_001", "이미 등록된 과목입니다."),
    INVALID_INPUT(HttpStatus.BAD_REQUEST, "CMN_001", "입력값이 올바르지 않습니다."),
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "CMN_999", "서버에 문제가 발생했습니다.")
    ;


    private final HttpStatus status;

    private final String code;

    private final String message;

    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
