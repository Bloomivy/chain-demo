package com.chain.demo.validation;

import com.chain.demo.annotation.Length;
import com.chain.demo.annotation.Max;
import com.chain.demo.annotation.Min;

import java.lang.reflect.Field;


/**
 * @version 1.00
 * @author: Ivy
 * @date: 2025/5/24 15:16
 */
public class Validator {

    private ValidatorChain buildValidatorChain(Field field) {

        ValidatorChain chain = new ValidatorChain();
        Length length = field.getAnnotation(Length.class);
        if (length != null) {
            chain.addLastHandler(new LengthValidatorHandler(length.value()));
        }
        Max max = field.getAnnotation(Max.class);
        if (max != null) {
            chain.addLastHandler(new MaxValidatorHandler(max.value()));
        }

        Min min = field.getAnnotation(Min.class);
        if (min != null) {
            chain.addLastHandler(new MinValidatorHandler(min.value()));
        }
        return chain;
    }

   public void validator(Object bean) throws Exception {
        Class<?> beanClass = bean.getClass();
        for (Field filed : beanClass.getDeclaredFields()) {
            filed.setAccessible(true);
            ValidatorChain chain = buildValidatorChain(filed);
            chain.validate(filed.get(bean));
        }
    }
}
