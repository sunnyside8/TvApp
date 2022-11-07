package org.example.validation;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch,Object> {

    private String firstField;
    private String secondField;
    private String message;


    @Override
    public void initialize(FieldMatch constraintAnnotation) {
       this.firstField = constraintAnnotation.first();
       this.secondField = constraintAnnotation.second();
       this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(value);
        Object firstFieldValue = beanWrapper.getPropertyValue(firstField);
        Object secondFieldValue = beanWrapper.getPropertyValue(secondField);
        boolean valid = true;

        if(firstFieldValue == null){
            valid = secondFieldValue == null;
        } else{
            valid = firstFieldValue.equals(secondFieldValue);
        }

        if(!valid){
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(firstField)
                    .addConstraintViolation()
                    .buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(secondField)
                    .addConstraintViolation().disableDefaultConstraintViolation();
            ;
        }
        return valid;
    }
}
