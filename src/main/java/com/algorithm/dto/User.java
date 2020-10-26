package com.algorithm.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private String name;

    private String phone;

    private transient String testId;

    private static String testStatic;

    public User(){
        testStatic = "testStatic";
    }

    public static String getTestStatic() {
        return testStatic;
    }

    public static void setTestStatic(String testStatic) {
        User.testStatic = testStatic;
    }
}
