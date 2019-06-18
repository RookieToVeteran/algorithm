package com.algorithm.hash.base;

import java.util.HashMap;

/**
 * @program: algorithm
 * @description: 简单的hash算法
 * @author: pengpeng.wang.o
 * @create: 2019-06-10
 **/
public class BaseHash {

    public static void main(String[] args) {

        new HashMap<>(15);
    }

    /**
     * 平方取中法 （key为32位正整数）
     * @param key
     * @return
     */
    public static int directAddressingHash(int key){
        key = key * key;
        key >>= 11;
        return key % 10;
    }

    public static int ELFhash(char  key){
         long h = 0L,g;
return 0;
    }
}
