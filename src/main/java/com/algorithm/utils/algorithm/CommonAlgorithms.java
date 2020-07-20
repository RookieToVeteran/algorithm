package com.algorithm.utils.algorithm;

import com.algorithm.dto.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
     *
     *  直接插入排序的时间复杂度是O(N2)。
     * 假设被排序的数列中有N个数。遍历一趟的时间复杂度是O(N)，需要遍历多少次呢？N-1！因此，直接插入排序的时间复杂度是O(N2)。
     *
     *  取出无序区中的第1个数，并找出它在有序区对应的位置。(2)将无序区的数据插入到有序区；若有必要的话，则对有序区中的相关数据进行移位。
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
     * 直接插入排序 2   时间复杂度： O(n^2) 空间复杂度 ： O(1)
     * @return
     */
    public static void straightInsertionSort(int [] array){
        if (array == null || array.length < 2){
            return ;
        }
        for (int i = 1; i < array.length; i++) {
            int cur = array[i];
            boolean flag = false;
            for (int j = i-1; j > -1; j--) {
               if (cur >= array[j]){
                   array[j+1] = cur;
                   flag = true;
                   break;
               }else{
                  array[j+1] = array[j];
               }
            }
            if (!flag){
                array[0] = cur;
            }
        }


    }

    /**
     * 直接插入排序—设置哨兵位  时间复杂度： O(n^2) 空间复杂度 ： O(1)
     * @return
     */
    public static void InsertionSortWithSentry(int [] array){
        if (array == null || array.length < 2){
            return ;
        }
        int preV = array[0];
        int preIndex = 0;
        for (int i = 1; i < array.length; i++) {
            int cur = array[i];
            int startIndex = i - 1;
            //DESC 当前value小于上一个value，可以假定当前value就是上一个value,当前value与上一个value中间的值整体往后移动
            if (cur < preV){
                startIndex = preIndex;
                for (int j = i-1; j > startIndex - 1; j--) {
                   array[j+1]= array[j];
                }
            }

            boolean flag = false;
            for (int j = startIndex; j > -1; j--) {
                if (cur >= array[j]){
                    array[j+1] = cur;
                    preV = cur;
                    preIndex = j+1;
                    flag = true;
                    break;
                }else{
                    array[j+1] = array[j];
                }
            }
            if (!flag){
                array[0] = cur;
                preV = cur;
                preIndex = 0;
            }
        }


    }



    /**
     * 快速排序
     */
    public static void quickSort(){


    }

    /**
     * 区间合并算法: 时间复杂度： O(n),空间复杂度：O(1)
     * @param intervalList : 区间对象
     * @return
     */
    public static List<Interval> merge(List<Interval> intervalList){
        List<Interval> mergedIntervalList = new ArrayList<>();
        if (intervalList==null || intervalList.isEmpty()){
            return mergedIntervalList;
        }
        if (intervalList.size()==1){
            return mergedIntervalList;
        }

        //升序排序——后一个区间next的start一定不小于前一个区间pre的start，如果next.start > pre.end,则区间没有交集，否则，pre和next区间进行合并
        Collections.sort(intervalList, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.getStart()-o2.getStart();
            }
        });


        Interval pre = null;
        int temp ;
        for (Interval interval : intervalList) {
            if (pre==null || pre.getEnd() < interval.getStart()){
                pre = interval;
                mergedIntervalList.add(pre);
            }else {
               temp = pre.getEnd()>=interval.getEnd()?pre.getEnd(): interval.getEnd();
               pre.setEnd(temp);
            }
        }

        return mergedIntervalList;
    }

}
