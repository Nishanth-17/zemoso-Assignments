package com.example.springsecuritylogin.Validation;

import com.example.springsecuritylogin.Entity.Rating;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class RatingValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Rating.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Rating rating=(Rating) o;

        final Pattern rating_regex=Pattern.compile("^[1-8]{1}$");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rating", "NotEmpty");
        if (rating.getRating()>5 || rating.getRating()<1) {
            errors.rejectValue("rating", "item.rating.invalid");
        }
    }
}
