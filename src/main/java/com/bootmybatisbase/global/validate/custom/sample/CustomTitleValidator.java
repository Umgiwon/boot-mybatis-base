package com.bootmybatisbase.global.validate.custom.sample;

import com.bootmybatisbase.global.annotation.sample.ValidTitle;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;

public class CustomTitleValidator implements ConstraintValidator<ValidTitle, String> {

    @Override
    public boolean isValid(String title, ConstraintValidatorContext context) {
        return !StringUtils.isNotEmpty(title) && title.length() <= 30;
    }
}
