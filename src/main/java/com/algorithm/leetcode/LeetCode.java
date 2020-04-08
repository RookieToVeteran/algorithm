package com.algorithm.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: algorithm
 * @description: leetCode算法题
 * @author: pengpeng.wang.o
 * @create: 2019-11-01
 **/
public class LeetCode {


	private static Logger logger = LoggerFactory.getLogger(LeetCode.class);

	public static void main(String[] args) {


	}


	/**
	 *给 定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和
	 * 为目标值的那两个整数，并返回他们的数组下标
	 */


	/**
	 * 方法1 ：遍历实现   ——> 时间复杂度 O（n^2） 空间复杂度O(1)
	 */
	public static int[] twoNums(int [] nums ,int target){
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			for (int j = nums.length-1 ; j > i ; j--) {
				int num1 = nums[j];
				if (target -num == num1){
					return new int[]{i,j};
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	/**
	 * 方法2 ：遍历实现   ——> 时间复杂度 O（n） 空间复杂度O(n)
	 */
	public static int[] twoNums2(int [] nums ,int target){
		Map<Integer, Integer> map = new HashMap<>(nums.length);
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (map.containsKey(target-num)){
				return new int[]{i,map.get((target-num))};
			}else{
				map.put(num,i);
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}

	}

//	/**
//	 * leetCode 第二题，两数相加
//	 */
//	public static ListNode addTwoNumber(ListNode l1, ListNode l2){
//		ListNode p1 = l1;
//		ListNode p2 = l2;
//
//
//	}


}
