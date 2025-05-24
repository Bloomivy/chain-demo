package com.chain.demo.validation;

import com.chain.demo.exception.validatorException;

import java.util.InvalidPropertiesFormatException;

/**
 * @version 1.00
 * @author: Ivy
 * @date: 2025/5/24 15:32
 */
public class MinValidatorHandler implements validatorHandler {

    public final int min;

    public MinValidatorHandler(int min) {
        this.min = min;
    }

    @Override
    public void validator(Object value, ValidatorContext context) {
        Object name = context.dataGet("name");
        if(name != null) {
            System.out.println(name.toString());
        }
        if (value instanceof Integer valueInt) {
            if (valueInt < min) {
                context.appendError("你的值是：" + valueInt + "小于最小值" + min);
            }
        }
    }
}
