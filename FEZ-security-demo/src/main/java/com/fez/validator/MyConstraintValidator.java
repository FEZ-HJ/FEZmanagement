package com.fez.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by H.J
 * 2018/10/2
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {

    @Override
    public void initialize(MyConstraint myConstraint) {
        System.out.println("MyConstraintValidator init");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        System.out.println(value);

        return false;
    }
}
