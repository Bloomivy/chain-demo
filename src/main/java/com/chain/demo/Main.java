package com.chain.demo;

import com.chain.demo.validation.Validator;

/**
 * @author: 20838
 * @date: 2025/5/24 15:01
 * @description:
 */
public class Main {
    public static void main(String[] args) throws Exception{
        User user = new User("1234", 18);

        Validator validator = new Validator();
        validator.validator(user);
    }
}