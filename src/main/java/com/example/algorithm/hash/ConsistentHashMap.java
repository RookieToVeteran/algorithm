package com.example.algorithm.hash;

import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: algorithm
 * @description: 一致性hashMap
 * @author: pengpeng.wang.o
 * @create: 2019-06-14
 **/
public class ConsistentHashMap {

    private Node[] buckets;


    /**
     * 默认长度
     */
    private static final int DEFAULT_SIZE = 10;

    /**
     * 扩容因子
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public ConsistentHashMap() {
        buckets = new Node[DEFAULT_SIZE];
    }

    /**
     * 顺时针取出数据（空的Node节点除去）
     * @param key
     * @return
     */
    public Object getFirstNodeValue(String key){
        List<Integer> list = new ArrayList<>();
        if (StringUtils.isEmpty(key)){
            return null;
        }
        for (int i = 0; i < buckets.length; i++) {
            Node bucket = buckets[i];
            if (bucket==null){
                continue;
            }
            if (bucket.key>hash(key)){
                list.add(i);
            }
        }
        if (list.isEmpty()){
            return buckets[0].value;
        }else {
            Collections.sort(list);
            return buckets[list.get(0)].value;
        }
    }

    /**
     * 校验是否需要扩容
     * @param size
     */
    private void check(int size) {
        if (size > (int)(buckets.length*DEFAULT_LOAD_FACTOR)){
            //扩容
            int newLen = buckets.length + (int)(buckets.length*DEFAULT_LOAD_FACTOR);
            buckets = Arrays.copyOf(buckets,newLen);
        }
    }

    /**
     * hash算法
     * @param key
     * @return
     */
    public static int hash(String key){
        if (StringUtils.isEmpty(key)){
            return 0;
        }
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            key = new String(md5.digest(key.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        int hash = 6639;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            hash += hash<<5 + ch;
        }

        return hash>0?hash:-hash;

    }

    /**
     * 数据节点
     */
    private class Node<V>{
        private Integer key ;
        private V value;

        public Node(Integer key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
}
