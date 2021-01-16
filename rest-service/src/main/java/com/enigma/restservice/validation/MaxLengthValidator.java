package com.enigma.restservice.validation;

import com.enigma.restservice.validation.annotations.MaxLength;
import com.enigma.restservice.validation.annotations.MinLength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MaxLengthValidator implements ConstraintValidator<MaxLength, String> {

    private MaxLength contraint;

    @Override
    public void initialize(MaxLength constraintAnnotation) {
        contraint = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        int length = value != null ? value.length() : 0;
        return length <= contraint.value();
    }
}
