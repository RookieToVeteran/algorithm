package com.algorithm.entity.vo;

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

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
