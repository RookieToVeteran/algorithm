package com.example.algorithm.hash;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: algorithm
 * @description: 一致性Hash
 * @author: pengpeng.wang.o
 * @create: 2019-06-13
 **/
public class SortArrayMap {

    /**
     * 节点数组
     */
    private Node[] buckets;

    /**
     * 默认长度
     */
    private static final int DEFAULT_SIZE = 10;
    /**
     *
     */
    private int size = 0;

    /**
     * 扩容因子
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    /**
     * 初始化buckets
     */
    public SortArrayMap() {
        buckets = new Node[DEFAULT_SIZE];
    }

    /**
     * 写入数据
     * @param key
     * @param value
     */
    public void add(Long key,String value){
        check(size+1);
        Node node = new Node(key, value);
        buckets[size++] = node;
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
     * 排序
     */
  public void sort(){
      System.out.println(size);
      //todo  空的Node节点不能进行排序
        Arrays.sort(buckets, 0,size, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.key >= o2.key) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
  }


    /**
     * 顺时针取出数据（空的Node节点除去）
     * @param key
     * @return
     */
  public String getFirstNodeValue(Long key){
    if (size==0){
        return null;
    }
      for (Node bucket : buckets) {
          if (bucket==null){
              continue;
          }
          if (bucket.key >=key){
              return bucket.value;
          }
      }
      return buckets[0].value;
  }

    /**
     * 数据节点
     */
    private class Node{
        public Long key ;
        public String value;

        public Node(Long key, String value) {
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
