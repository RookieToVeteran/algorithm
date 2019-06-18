package com.algorithm.hash.abs;

/**
 * @program: algorithm
 * @description: 一致性hash算法抽象 (便于多种实现)
 * @author: pengpeng.wang.o
 * @create: 2019-06-14
 **/
public abstract class AbstractConsistentHash {

    /**
     * 新增节点
     * @param key
     * @param value
     */
    protected abstract void add(long key,String value);

    /**
     * 排序节点，数据结构自身支持排序的可以不用重写
     */
    protected void sort(){}

    /**
     * 根据当前key 通过一致性hash算法 规则取出一个节点
     * @param key
     * @return
     */
    protected abstract String getFirstNodeValue(String key);




}
