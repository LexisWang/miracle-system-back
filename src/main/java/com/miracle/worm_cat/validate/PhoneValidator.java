package com.miracle.worm_cat.validate;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * author: Miracle-
 * time: 2022/10/25 23:18
 */
public class PhoneValidator implements ConstraintValidator<PhoneValue, String> {

    private static final Pattern PHONE_PATTERN = Pattern.compile(
            "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$"
    );

    @Override
    public boolean isValid(String phoneValue, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.isBlank(phoneValue) || PHONE_PATTERN.matcher(phoneValue).matches();
    }
}
