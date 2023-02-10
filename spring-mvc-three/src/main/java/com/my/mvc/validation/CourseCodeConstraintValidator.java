package com.my.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
        implements ConstraintValidator<CourseCode, String> {

    private String[] codePrefix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        codePrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
        
        boolean result = false;

        if (string != null) {
            for (String prefix :
                    codePrefix) {
                result = string.startsWith(prefix);
                if (result) {
                    break;
                }
            }
        }
        return result;
    }
}
