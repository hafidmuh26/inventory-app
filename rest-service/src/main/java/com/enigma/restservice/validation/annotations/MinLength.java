package com.enigma.restservice.validation.annotations;

import com.enigma.restservice.validation.MinLengthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MinLengthValidator.class)
@Documented
public @interface MinLength {

    String message() default "{com.enigma.restservice.validation.annotations.MinLength.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int value();

    @Target({ElementType.FIELD, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        MinLength[] value();
    }

}
