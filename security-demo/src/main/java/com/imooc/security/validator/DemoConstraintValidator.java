package com.imooc.security.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DemoConstraintValidator implements ConstraintValidator<DemoConstraint, Object> {

    //可以用autowired注入服务，不用加component

    @Override
    public void initialize(DemoConstraint demoConstraint) {
        System.out.println("init demo validator");
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println(o);
        return false;
    }
}
