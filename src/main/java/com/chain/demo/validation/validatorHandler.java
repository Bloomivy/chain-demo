package com.chain.demo.validation;

import com.chain.demo.exception.validatorException;

/**
 * @version 1.00
 * @author: Ivy
 * @date: 2025/5/24 15:24
 */
public interface validatorHandler {

    void validator(Object value, ValidatorContext context);
}
