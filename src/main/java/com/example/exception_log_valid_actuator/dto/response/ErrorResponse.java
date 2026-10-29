package com.example.exception_log_valid_actuator.dto.response;

import com.example.exception_log_valid_actuator.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponse {
    private String code;
    private String message;


    public static ErrorResponse of(ErrorCode errorCode){
        return new ErrorResponse(errorCode.getCode(), errorCode.getMessage());
    }


}
