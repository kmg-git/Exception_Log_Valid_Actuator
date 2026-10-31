package com.example.exception_log_valid_actuator.exception;

import com.example.exception_log_valid_actuator.dto.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBase(BaseException e) {

        ErrorCode errorCode = e.getErrorCode();
        log.warn("요청이 실패했습니다. code={}, message={}", errorCode.name(), e.getMessage());

        return ResponseEntity.status(errorCode.getStatus())
                .body(ErrorResponse.of(errorCode));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class )
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException e) {

        List<ErrorResponse.FieldError> errors = e.getBindingResult().getFieldErrors().stream()
                .map(fe -> new ErrorResponse.FieldError(fe.getField(), fe.getDefaultMessage()))
                .toList();

        log.warn("입력값 검증 실패 {}", errors.stream()
                .map(fe -> fe.getField() + "=" + fe.getMessage())
                .toList());

        return ResponseEntity.status(ErrorCode.INVALID_INPUT.getStatus())
                // 필드별 메시지는 errors 에 담습니다. getFieldErrors() 의 순서는 보장되지 않으므로
                // message 에는 고정 문구를 씁니다.
                .body(ErrorResponse.of(ErrorCode.INVALID_INPUT, errors));
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {

        //ErrorCode errorCode = e.getErrorCode();
        log.error("요청이 실패했습니다. 상정되지 않은 오류", e);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.of(ErrorCode.INTERNAL_ERROR));
    }

}
