package com.nik.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    //course code
    String value() default "NIK";

    //error message
    String message() default "must start with NIK";

    //groups
    Class<?>[] groups() default {};

    //payloads
    Class<? extends Payload>[] payload() default {};
}
