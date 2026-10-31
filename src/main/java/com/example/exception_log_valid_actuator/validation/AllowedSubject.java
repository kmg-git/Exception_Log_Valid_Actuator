package com.example.exception_log_valid_actuator.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AllowedSubjectValidator.class)
public @interface AllowedSubject {

    String message() default "없는 과목입니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
