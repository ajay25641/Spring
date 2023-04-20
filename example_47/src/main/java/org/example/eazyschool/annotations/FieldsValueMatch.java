package org.example.eazyschool.annotations;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.eazyschool.validations.FieldsValueMatchValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FieldsValueMatchValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldsValueMatch {

    Class<?>[] groups() default {};
    String message() default "fields value don't match !";

    Class<? extends Payload>[] payload() default {};

    String field();
    String fieldMatch();

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface List{
        FieldsValueMatch[] value();
    }
}
