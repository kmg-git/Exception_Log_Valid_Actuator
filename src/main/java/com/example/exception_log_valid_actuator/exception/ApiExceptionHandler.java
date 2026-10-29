package com.example.exception_log_valid_actuator.exception;

import com.example.exception_log_valid_actuator.dto.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBase(BaseException e) {

        ErrorCode errorCode = e.getErrorCode();
        //log.warn("요청이 실패했습니다. code={}, message={}", errorCode.name(), e.getMessage());

        return ResponseEntity.status(errorCode.getStatus())
                .body(ErrorResponse.of(errorCode));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {

        //ErrorCode errorCode = e.getErrorCode();
        //log.warn("요청이 실패했습니다. code={}, message={}", errorCode.name(), e.getMessage());

        return ResponseEntity.status(ErrorCode.INTERNAL_ERROR.getStatus())
                .body(ErrorResponse.of(ErrorCode.INTERNAL_ERROR));
    }

}
