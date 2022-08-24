package com.godofparking.jeogidabackend.validation;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class NullOrNotBlankValidator implements ConstraintValidator<NullOrNotBlank, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.info("isValid: {}", value == null || !value.isBlank());
        return value == null || !value.isBlank();
    }

}
