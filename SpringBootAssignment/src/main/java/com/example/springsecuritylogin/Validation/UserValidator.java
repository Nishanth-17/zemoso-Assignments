package com.example.springsecuritylogin.Validation;

import com.example.springsecuritylogin.Entity.User;
import com.example.springsecuritylogin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;


    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        final Pattern email_regex=Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
        final Pattern mobile_regex=Pattern.compile("[0-9]{10}");

        if (user.getUsername().length() < 3 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }

        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if (!email_regex.matcher(user.getEmail()).matches()) {
            errors.rejectValue("email", "user.email.invalid");
        }

        if (userService.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate.userForm.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobile", "NotEmpty");
        if (!mobile_regex.matcher(user.getMobile()).matches()) {
            errors.rejectValue("mobile", "user.mobile.invalid");
        }

        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }

    public void validateUpdate(Object o, Errors errors) {
        User user = (User) o;

        final Pattern mobile_regex=Pattern.compile("[0-9]{10}");


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobile", "NotEmpty");
        if (!mobile_regex.matcher(user.getMobile()).matches()) {
            errors.rejectValue("mobile", "user.mobile.invalid");
        }

    }
    public void validateUpdatePassword(Object o, Errors errors) {
        User user = (User) o;

        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}
