package com.algorithm.test.single;

/**
 * 静态内部类实现单例 (线程安全，调用效率高，可以延时加载）
 */
public class SingleObject3 {

    private SingleObject3(){}

    public static SingleObject3 getInstance(){
       return Instance.instance;
    }

    private static class Instance{
        private static final SingleObject3 instance = new SingleObject3();
    }
}
