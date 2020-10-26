package com.algorithm.test.LRU;

public class TestLRU {

    public static void main(String[] args) throws InterruptedException {
        LRU lru = new LRU();

        for (int i = 0; i <10; i++) {
            System.out.println("add  value "+i);
            Thread.sleep(10);
            lru.set(i+"",Integer.valueOf(i),i*1000L);
        }

        Thread.sleep(4000);

        for (int i = 10; i <20; i++) {
            System.out.println("add  value ------ "+i);
            Thread.sleep(10);
            lru.set(i+"",Integer.valueOf(i),i*100L);
        }
    }
}
