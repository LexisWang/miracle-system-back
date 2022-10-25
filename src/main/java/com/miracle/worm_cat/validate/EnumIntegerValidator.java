package com.miracle.worm_cat.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * author: Miracle-
 * time: 2022/7/29 13:04
 */
public class EnumIntegerValidator implements ConstraintValidator<EnumValue, Integer> {

    private static final Set<Integer> enumValues = new HashSet<>();

    @Override
    public void initialize(EnumValue constraintAnnotation) {
        int[] values = constraintAnnotation.values();
        for (int value : values) {
            enumValues.add(value);
        }
    }

    @Override
    public boolean isValid(Integer enumValue, ConstraintValidatorContext constraintValidatorContext) {
        return null == enumValue || enumValues.contains(enumValue);
    }
}
