package com.godofparking.jeogidabackend.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NullOrNotBlankValidator.class)
public @interface NullOrNotBlank {

    String message() default "공백을 값으로 가질 수 없습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
