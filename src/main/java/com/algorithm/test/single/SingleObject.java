package com.algorithm.test.single;

/**
 * 饿汉式 (线程安全，调用效率高，但是不能延时加载)
 */
public class SingleObject {

    private static SingleObject instance = new SingleObject();

    private SingleObject(){

    }

    public static SingleObject getInstance(){
        return instance;
    }
}
