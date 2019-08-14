package com.algorithm.utils.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: algorithm
 * @description: 常见算法
 * @author: pengpeng.wang.o
 * @create: 2019-07-25
 **/
public class CommonAlgorithms {

    private static Logger LOGGER = LoggerFactory.getLogger(CommonAlgorithms.class);

    /**
     * 查询算法
     */

    /**
     * 二分查找  --- 前提是数组有序
     * @param targetArray
     * @param target
     * @return
     */
    public static boolean binarySearch(int[] targetArray,int target){
        //查询次数
        int count = 0;
        int low = 0;
        int high = targetArray.length - 1;
        while (low <= high){
            count ++ ;
            int middle = (low + high) / 2;
            int assumeValue = targetArray[middle];
            if (assumeValue==target){
                LOGGER.info("******二分查找执行次数=【{}】******",count);
                return true;
            }else if (assumeValue > target){
                high = middle - 1;
            }else {
                low = middle + 1;
            }
        }
        return false;
    }

    /**
     * 排序算法
     */

    /**
     *  直接插入排序 ---把n个待排序的元素看成为一个有序表和一个无序表。开始时有序表中只包含1个元素，
     *  无序表中包含有n-1个元素，排序过程中每次从无序表中取出第一个元素，将它插入到有序表中的适当位置，
     *  使之成为新的有序表，重复n-1次可完成排序过程。
     *  它是一种稳定的排序算法，特别适合于待排序序列基本有序的情况
     * @param targetArray
     */
    public static void insertSort(int[] targetArray){
       int i , j , k;
        for ( i = 1; i < targetArray.length; i++) {
            //为targetArray[i]在前面的targetArray[0...i-1]有序区间中找一个合适的位置
            for ( j = i - 1; j >= 0 ; j--) {
                if(targetArray[j] <= targetArray[i]){
                    break;
                }
            }
            //如找到了一个合适的位置
            //todo 此处j的值是由上一个for循环得到的，根据j的值可间接找到targetArray[i]合适的位置
            if (j != i - 1) {
                //将比i大的数往后移
                int temp = targetArray[i];
                for ( k = i-1; k > j; k--) {
                   targetArray[k+1] = targetArray[k];
                    targetArray[k] = temp;
                }
            }
        }
    }


    /**
     * 冒泡排序
     * @param targetArray
     */
    public static void bubbleSort(int[] targetArray){



    }


    /**
     * 快速排序
     */
    public static void quickSort(){


    }

}
