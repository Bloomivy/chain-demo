package com.chain.demo.validation;

import com.chain.demo.exception.validatorException;

/**
 * @version 1.00
 * @author: Ivy
 * @date: 2025/5/24 15:25
 */
public class MaxValidatorHandler implements validatorHandler {

    public final int max;

    public MaxValidatorHandler(int max) {
        this.max = max;
    }

    @Override
    public void validator(Object value, ValidatorContext context) {
        if (value instanceof Integer intValue) {
            if (intValue > max) {
                context.appendError("你的值是：" + intValue + "超过最大值：" + max);
                // 控制校验链
                //context.stopChain();
            }
        }
        context.dataPut("name", "jing");
        context.doNext(value);
    }
}
