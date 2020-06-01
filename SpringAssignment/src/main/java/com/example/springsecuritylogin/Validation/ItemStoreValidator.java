package com.example.springsecuritylogin.Validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.springsecuritylogin.Entity.ItemStore;
import org.springframework.validation.ValidationUtils;

import java.util.regex.Pattern;
@Component
public class ItemStoreValidator implements Validator {

        @Override
        public boolean supports(Class<?> aClass) {
            return ItemStore.class.equals(aClass);
        }

        @Override
        public void validate(Object o, Errors errors) {
            ItemStore itemStore=(ItemStore) o;
            final Pattern name_regex=Pattern.compile("^[a-zA-Z0-9 &]*$");
            final Pattern price_regex=Pattern.compile("^[1-9]\\d{0,5}(?:\\.\\d{1,2})?$");
            final Pattern company_regex=Pattern.compile("^[a-zA-Z0-9 .\\-@&]*$");

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itemName", "NotEmpty");
            if (!name_regex.matcher(itemStore.getItemName()).matches()) {
                errors.rejectValue("itemName", "itemStore.name.invalid");
            }
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty");
            if (!price_regex.matcher(String.valueOf(itemStore.getPrice())).matches()) {
                errors.rejectValue("price", "itemStore.price.invalid");
            }
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "company", "NotEmpty");
            if (!company_regex.matcher(itemStore.getCompany()).matches()) {
                errors.rejectValue("company", "itemStore.company.invalid");
            }
        }
    }