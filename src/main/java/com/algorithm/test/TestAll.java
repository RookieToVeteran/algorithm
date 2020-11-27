package com.algorithm.test;

import com.algorithm.test.single.SingleObject3;
import com.algorithm.test.single.SingleObjectEnum;

import java.util.HashMap;
import java.util.HashSet;

public class TestAll {

    public static void main(String[] args) {
        SingleObjectEnum instance = SingleObjectEnum.INSTANCE;
        SingleObject3 value = instance.getValue();


        test();

        System.out.println(test1());
    }


    public static void test(){
        String str = "123";

        StringBuilder stringBuilder = new StringBuilder();

        StringBuffer stringBuffer = new StringBuffer();

    }


    public static int test1(){

      int i = 2;
        try {
            return test2(i);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            i = i+1;
            return i;
        }

    }

    private static int test2(int i) {
        return i+3;
    }
}
