package com.algorithm.utils.algorithm;

/**
 * 常见排序算法
 */
public class SortAlgorithms {


    /**
     * 交换排序之 —— 冒泡排序 --- 稳定排序
     * 思路： 1.外层控制排序的趟数，
     *       2.内层从第一个元素开始，依次与下一个元素比较， 出现逆序就交换，
     *       通过与相邻元素的比较，交换，依次把大的数交换排序到后面。
     * <p>
     * 时间复杂度： O(n^2)
     * 空间复杂度： O(1)
     * </p>
     */
    public static void bubbleSort(int[] arr) {
        int temp ;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * 交换排序之 —— 快速排序（分治思想）--- 不稳定
     * 思路：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，
     * 则可分别对这两部分记录继续进行排序，以达到整个序列有序。
     *时间复杂度O(NlogN)
     *空间复杂度
     *
     */
    public static void quickSort(int[] arr,int min,int max){
        if (min > max){
            return;
        }
        int left = min;
        int right = max;

        //设置基准值，一般设置最左端的元素为基准值
        int bv = arr[left];

        while (left!=right){
            //往左移动查询，直到大于bv
            while (left<right && arr[right] >=bv){
                right--;
            }
            //往右移，直到小于bv
            while (left<right && arr[left] <= bv){
                left++;
            }

            if (left<right){
                int temp = arr[left];
                arr[left]= arr[right];
                arr[right]=temp;
            }
        }
        //交换基数
        int temp = arr[left];
        arr[left]=bv;
        arr[min] = temp;

        //迭代左边和右边
        quickSort(arr,min,left-1);
        quickSort(arr,right+1,max);

    }

}
