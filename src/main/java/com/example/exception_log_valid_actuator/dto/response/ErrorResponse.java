package com.example.exception_log_valid_actuator.dto.response;

import com.example.exception_log_valid_actuator.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.MDC;

import java.util.List;

@AllArgsConstructor
@Getter
public class ErrorResponse {
    private String code;
    private String message;
    private List<FieldError> errors;


    public static ErrorResponse of(ErrorCode errorCode){
        return new ErrorResponse(errorCode.getCode(), errorCode.getMessage(),null);
    }

    public static ErrorResponse of(ErrorCode errorCode, List<FieldError> errors) {
        // RequestIdFilter 가 MDC 에 넣어 둔 값. 필터가 안 떠 있으면 null 입니다.
        return new ErrorResponse(errorCode.name(), errorCode.getMessage(), errors);
    }



    @Getter
    @AllArgsConstructor
    public static class FieldError {

        private String field;
        private String message;
    }

}
