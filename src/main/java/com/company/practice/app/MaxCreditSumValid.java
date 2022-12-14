package com.company.practice.app;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MaxCreditSumValidator.class)
public @interface MaxCreditSumValid {
    String message() default "CreditSum is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
