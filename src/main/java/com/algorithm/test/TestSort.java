package com.algorithm.test;

import com.algorithm.utils.algorithm.SortAlgorithms;

public class TestSort {

    public static void main(String[] args) {

//        Integer.valueOf(40)
        //冒泡排序
        int[] ints = {131, 25, 21, 7, 3, 4, 6, 9};
        String absv = new String("absv");
        String intern = absv.intern();

        SortAlgorithms.bubbleSort(ints);

        //快速排序
        int[] arr = {6,1,2,7,9,3,4,5,10,8};
        SortAlgorithms.quickSort(arr,0,arr.length-1);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
