package com.algorithm.test;

import com.algorithm.utils.algorithm_project.CommonAlgorithms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: algorithm
 * @description: 算法测试
 * @author: pengpeng.wang.o
 * @create: 2019-07-25
 **/
public class TestAlgorithm {

    private static Logger LOGGER = LoggerFactory.getLogger(TestAlgorithm.class);

    public static void main(String[] args) {
        //二分查找
        testBinarySearch();
    }


    /**
     * 二分查找
     */
    private static void testBinarySearch() {
        int[]  targetArray = new int[1000];
        for (int i = 0; i < 1000; i++) {
            targetArray[i] = i;
        }
        int target = 512;
        boolean result = CommonAlgorithms.binarySearch(targetArray, target);
        LOGGER.info("******二分查找结果【{}】******",result);
    }


}
