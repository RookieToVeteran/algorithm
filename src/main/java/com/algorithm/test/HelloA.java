package com.algorithm.test;

public class HelloA {
    public HelloA() {
        System.out.println("HelloA");
    }
    { System.out.println("I'm A class"); }

    static { System.out.println("static A"); }
}
 class HelloB extends HelloA {
    public HelloB() {
        System.out.println("HelloB");
    }
    { System.out.println("I'm B class"); }

    static { System.out.println("static B"); }

    public static void main(String[] args) {

        System.out.println("-------main start-------");
        new HelloA();
        System.out.println("=================");
        new HelloB();
        System.out.println("-------main end-------");
    }
}
