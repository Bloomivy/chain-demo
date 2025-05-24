package com.chain.demo.validation;

import com.chain.demo.exception.validatorException;

/**
 * @version 1.00
 * @author: Ivy
 * @date: 2025/5/24 15:33
 */
public class LengthValidatorHandler implements validatorHandler{

    public final int length;

    public LengthValidatorHandler(int length) {
        this.length = length;
    }

    @Override
    public void validator(Object value, ValidatorContext context)  {
        if (value instanceof String intValue) {
            if (intValue.length() != length) {
                context.appendError("你的长度是：" + intValue.length() + "不等于指定长度：" + length);
            }
        }
    }
}
