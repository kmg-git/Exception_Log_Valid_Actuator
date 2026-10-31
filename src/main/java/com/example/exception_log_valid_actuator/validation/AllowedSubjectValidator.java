package com.example.exception_log_valid_actuator.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class AllowedSubjectValidator implements ConstraintValidator<AllowedSubject,String> {

    private static final  List<String> SUBJECT = List.of("국어","영어","수학","사회","과학");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;   // 값이 없는 것은 @NotBlank 가 볼 일입니다
        }

        return SUBJECT.contains(value);

        //return false;
    }
}
