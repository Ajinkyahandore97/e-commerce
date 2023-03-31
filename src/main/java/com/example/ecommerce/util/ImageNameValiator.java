package com.example.ecommerce.util;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class ImageNameValiator implements ConstraintValidator<ImageNameValid,String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        log.info("Message from invalid : {} " ,value);

        if(value.isBlank())
        {
            return false;
        }else
        {
            return  true;
        }
    }


    }

