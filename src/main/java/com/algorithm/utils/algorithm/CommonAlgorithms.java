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
}
