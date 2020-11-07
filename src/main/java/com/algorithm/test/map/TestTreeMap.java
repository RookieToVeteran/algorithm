package com.algorithm.test.map;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestTreeMap {

    public static void main(String[] args) {
        TreeMap<Long, TreeSet<Long>> treeMap = new TreeMap<>();

        TreeSet<Long> set1 = new TreeSet<>();
        TreeSet<Long> set2 = new TreeSet<>();
        TreeSet<Long> set3 = new TreeSet<>();

        set2.add(1L);
        set2.add(2L);
        set2.add(3L);

        treeMap.put(11L,set1);
        treeMap.put(12L,set2);
        treeMap.put(13L,set3);

        Iterator<Long> iterator = treeMap.keySet().iterator();
        while (iterator.hasNext()){
            Long next = iterator.next();
            if (next==11L || next ==12L){
                treeMap.remove(next);
            }
        }

    }

}
