package com.example.algorithm.common.vo;

/**
 * @program: algorithm
 * @description: 基础视图类
 * @author: pengpeng.wang.o
 * @create: 2019-06-17
 **/
public class BaseResult {

    private boolean flag ;

    private Object obj;

    private String msg;


    public BaseResult(boolean flag, Object obj, String msg) {
        this.flag = flag;
        this.obj = obj;
        this.msg = msg;
    }

    public BaseResult(boolean flag, Object obj) {
        this.flag = flag;
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "flag=" + flag +
                ", obj=" + obj +
                ", msg='" + msg + '\'' +
                '}';
    }
}
