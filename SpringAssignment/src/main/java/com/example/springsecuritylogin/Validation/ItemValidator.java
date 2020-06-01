package com.example.springsecuritylogin.Validation;

import com.example.springsecuritylogin.Entity.Item;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class ItemValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Item.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Item item=(Item) o;

        final Pattern quantity_regex=Pattern.compile("^[1-8]{1}$");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itemName", "NotEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "NotEmpty");
        if (item.getQuantity()>8 || item.getQuantity()<1) {
            errors.rejectValue("quantity", "item.quantity.invalid");
        }
    }
}