package com.algorithm.test.single;

/**
 * 枚举类（线程安全，调用效率高，不能延时加载，可以天然的防止反射和反序列化调用）
 */
public enum SingleObjectEnum {

    //枚举元素本身就是单例
    INSTANCE(SingleObject3.getInstance());

    private SingleObject3 value;

    SingleObjectEnum() {
    }

    SingleObjectEnum(SingleObject3 value) {
        this.value = value;
    }

    public SingleObject3 getValue() {
        return value;
    }

    public void singleton(){

    }
}
