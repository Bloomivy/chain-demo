package com.chain.demo.validation;

import com.chain.demo.exception.validatorException;

import javax.naming.directory.InvalidSearchControlsException;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.00
 * @author: Ivy
 * @date: 2025/5/24 15:42
 */
public class ValidatorChain {

    private final List<validatorHandler> handlers = new ArrayList<>();
    private int index = 0;

    public void addLastHandler(validatorHandler handler) {
        this.handlers.add(handler);
    }

    public void validate(Object value) throws validatorException {
        ValidatorContext context = new ValidatorContext(value);
        while (true) {
            int index = context.getIndex();
            if (index == handlers.size()) {
                break;
            }
            validatorHandler handler = handlers.get(index);
            handler.validator(context.getValue(), context);
            if (index == context.getIndex()) {
                break;
            }
        }
        context.throwExceptionIfNecessary();
    }
}
