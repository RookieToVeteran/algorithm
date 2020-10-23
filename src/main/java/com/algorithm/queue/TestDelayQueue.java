package com.algorithm.queue;

import java.util.concurrent.DelayQueue;

public class TestDelayQueue {
    public static void main(String[] args) {
        DelayQueue<TestDelayed> queue = new DelayQueue<>();
        queue.add(new TestDelayed(5,"test1"));
        queue.add(new TestDelayed(6,"test2"));
        queue.add(new TestDelayed(2,"test3"));
        while (queue.size() >0){
            TestDelayed poll = queue.poll();
            if (poll!=null){
                System.out.println(poll.getItem());
            }
        }
    }
}
