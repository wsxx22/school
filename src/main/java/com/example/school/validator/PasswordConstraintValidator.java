package com.example.school.validator;

import com.example.school.annotation.ValidPassword;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {

        context.disableDefaultConstraintViolation();

        if (password == null){
            context.buildConstraintViolationWithTemplate("Password cannot be null").addConstraintViolation();
            return false;
        }

        PasswordValidator validator = new PasswordValidator(List.of(
                new DigitCharacterRule(1),
                new SpecialCharacterRule(1),
                new UppercaseCharacterRule(1),
                new LengthRule(8,25),
                new WhitespaceRule()
        ));

        RuleResult result = validator.validate(new PasswordData(password));

        if (result.isValid()) {
            return true;
        }

        validator.getMessages(result).forEach(s -> context.buildConstraintViolationWithTemplate(s).addConstraintViolation());
        return false;
    }
}
