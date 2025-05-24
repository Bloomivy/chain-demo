package com.chain.demo.validation;

import com.chain.demo.exception.validatorException;

import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.00
 * @author: Ivy
 * @date: 2025/5/24 16:01
 */
public class ValidatorContext {

    List<String> errorMessages = new ArrayList<>();
    boolean stop = false;
    private int index = 0;
    private Object value;
    private Map<String, Object> data = new HashMap<>();

    public void appendError(String errorMessage) {
        errorMessages.add(errorMessage);
    }

    public void dataPut(String key, Object value) {
        this.data.put(key, value);
    }

    public Object dataGet(String key) {
        return this.data.get(key);
    }

    public ValidatorContext(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return this.value;
    }

    public void throwExceptionIfNecessary() {
        if (errorMessages.isEmpty()) {
            return;
        }
        throw new validatorException(errorMessages.toString());
    }

    public void stopChain() {
        this.stop = true;
    }

    public boolean shouldStop() {
        return this.stop;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

    public void doNext(Object value) {
        this.value = value;
        this.index++;
    }
}
