package com.chain.demo;

import com.chain.demo.annotation.Length;
import com.chain.demo.annotation.Max;
import com.chain.demo.annotation.Min;

/**
 * @author: Ivy
 * @date: 2025/5/24 15:05
 * @description: 
 */

public class User {

    @Length(4)
    private final String name;

    @Max(17)
    @Min(20)
    private final Integer year;

    public User(String name, Integer year) {
        this.year = year;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }
}
