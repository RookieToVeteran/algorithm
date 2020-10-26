package com.algorithm.test.LRU;


import org.apache.poi.ss.formula.functions.T;

import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LRU {

    /**
     * 清除过期数据的线程池
     */
    private static ScheduledExecutorService swapExpirePool = new ScheduledThreadPoolExecutor(10);

    /**
     * 数据存储容器
     */
    private static ConcurrentHashMap<String,Node> cacheMap = new ConcurrentHashMap(1024);

    /**
     * 存储过期数据
     */
    private PriorityQueue<Node<T>> expireNode = new PriorityQueue<>(1024);


    public LRU(){
        swapExpirePool.scheduleWithFixedDelay(new ExpireNode(), 1, 2, TimeUnit.SECONDS);
    }

    /**
     * 添加数据
     * @param key
     * @param value
     * @param ttl
     * @return
     */
    public Object set(String key, Object value, Long ttl){
        //过期时间
        long expireTime = System.currentTimeMillis()+ttl;
        //创建新的节点
        Node node = new Node<>(key, value, expireTime);
        //存入缓存和队列
        Node oldNode = cacheMap.put(key,node);
        expireNode.add(node);

        if (oldNode!=null){
            expireNode.remove(oldNode);
            return oldNode.getValue();
        }
        return null;
    }

    public Object get(String key){
        Node node = cacheMap.get(key);
        return node==null?null:node.getValue();
    }


    public class ExpireNode implements Runnable {

        @Override
        public void run() {
            long timeMillis = System.currentTimeMillis();
            while (true){
                System.out.println("run---------------------");
                Node<T> node = expireNode.peek();
                if (node==null || node.getExpireTime()>timeMillis){
                    return;
                }
                cacheMap.remove(node.getKey());
                expireNode.poll();
                System.out.println("移除节点 "+node.getValue());
                System.out.println("剩余节点梳理 "+expireNode.size());
            }
        }
    }

}
