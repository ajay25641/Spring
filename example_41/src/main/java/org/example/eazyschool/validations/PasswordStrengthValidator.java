package org.example.eazyschool.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.eazyschool.annotations.PasswordValidator;

import java.util.Arrays;
import java.util.List;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordValidator,String> {

    List<String> weakPasswords;
    @Override
    public void initialize(PasswordValidator passwordValidator){
        weakPasswords= Arrays.asList("123456789","qwerty","00000","password");
    }
    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {

        return (password != null && !weakPasswords.contains(password));
    }
}
