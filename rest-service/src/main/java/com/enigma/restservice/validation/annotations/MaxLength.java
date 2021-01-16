package com.enigma.restservice.validation.annotations;


import com.enigma.restservice.validation.MaxLengthValidator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MaxLengthValidator.class)
@Documented
public @interface MaxLength {
    String message() default "{com.enigma.restservice.validation.annotations.MaxLength.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int value();

    @Target({ElementType.FIELD, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        MaxLength[] value();
    }
}
