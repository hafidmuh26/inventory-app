package com.enigma.restservice.validation;

import com.enigma.restservice.validation.annotations.MinLength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinLengthValidator implements ConstraintValidator<MinLength, String> {

    private MinLength contraint;

    @Override
    public void initialize(MinLength constraintAnnotation) {
        contraint = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        int length = value != null ? value.length() : 0;
        return length >= contraint.value();
    }
}
