package org.example.eazyschool.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.eazyschool.validations.PasswordStrengthValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordStrengthValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValidator{
    String message() default "Please choose a strong password";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
