package com.algorithm.test;

import com.algorithm.test.single.SingleObject3;
import com.algorithm.test.single.SingleObjectEnum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class TestAll {

    public static void main(String[] args) {

        test6();
    }

    public static void test6(){
        LinkedList<Object> list = new LinkedList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        Object o = list.get(2);
        list.addFirst(2);
        Object peek = list.peek();
        int size = list.size();
        Object o1 = list.peekFirst();



    }

    //测试ArrayList扩容
    public static void test5(){
        int N = 10000000;
        List<Object> list = new ArrayList<>(N);
        long l = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long l1 = System.currentTimeMillis();
        System.out.println("提前扩容后耗时："+(l1-l)+" ms");
    }

    //测试ArrayList扩容
    public static void test4(){
        ArrayList<Object> list = new ArrayList<>();
        int N = 10000000;
        long l = System.currentTimeMillis();
        list.ensureCapacity(N);
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long l1 = System.currentTimeMillis();
        System.out.println("调用扩容方法后耗时："+(l1-l)+" ms");
    }

    //测试ArrayList扩容
    public static void test3(){
        ArrayList<Object> list = new ArrayList<>();
        int N = 10000000;
        long l = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long l1 = System.currentTimeMillis();
        System.out.println("调用扩容方法前耗时："+(l1-l)+" ms");
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
