package com.my.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = ValidEmailConstraintValidator.class)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidEmail {

    String message() default "invalid email";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
