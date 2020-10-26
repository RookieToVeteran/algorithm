package com.algorithm.test.LRU;

import lombok.Data;

@Data
public class Node<T> implements Comparable<Node<T>> {

    private String key;

    private T value;

    /**
     * 过期时间
     */
    private Long expireTime;

    /**
     * 按照时间升序排序
     * @param o
     * @return
     */
    @Override
    public int compareTo(Node o) {
        return this.expireTime - o.expireTime >= 0 ? 1 : -1;
    }


    public Node(String key, T value, Long expireTime) {
        this.key = key;
        this.value = value;
        this.expireTime = expireTime;
    }
}
