package com.algorithm.test.single;

/**
 * 懒汉式 (线程安全，调用效率不高，但是能延时加载)
 */
public class SingleObject2 {

    /**
     * 初始化，延时加载
     */
    private static SingleObject2 instance;

    private SingleObject2(){}

    public static synchronized SingleObject2 getInstance(){
        if (instance==null){
            instance = new SingleObject2();
        }
        return instance;
    }
}
