package com.algorithm.utils.structure.linkedlist;

import java.util.HashMap;

/**
 * @program: algorithm
 * @description:
 * @author: pengpeng.wang.o
 * @create: 2020-06-19
 **/
public class DoubleLinkTest {

	public static void main(String[] args) {
		DoubleLink<Integer> db = new DoubleLink<Integer>();
		db.insert(0,1);
		db.insert(1,2);
		DoubleLink<Integer>.DNode<Integer> node = db.getNode(0);
		System.out.println(node.value);
		HashMap<Object, Object> map = new HashMap<>();
//		map.put()；
	}
}
