package com.algorithm.utils.structure.linkedlist;

/**
 * @program: algorithm
 * @description: Java实现的双向链表
 * @author: pengpeng.wang.o
 * @create: 2020-06-18
 **/
public class DoubleLink<T> {
	/**
	 * 链表表头
	 */
	private DNode<T> headNode;

	/**
	 * 节点个数
	 */
	private int mCount;


	/**
	 * 双向链表的节点
	 */
	private class DNode<T> {
		private DNode pre;
		private DNode next;
		private T value;

		public DNode(DNode pre, DNode next, T value) {
			this.pre = pre;
			this.next = next;
			this.value = value;
		}
	}


	public DoubleLink() {
		DNode dNode = new DNode(null, null, null);
		dNode.next = dNode.pre = dNode;
		mCount = 0;
	}

	/**
	 * 返回节点数目
	 *
	 * @return
	 */
	public int size() {
		return mCount;
	}

	/**
	 * 链表是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return mCount == 0;
	}

	/**
	 * 查询索引位置的节点
	 * 注意： 只有循环链表才可以这样查询
	 * description: 在普通的双向链表中，如果我们要获取最后一个节点的时候，我们只能从头开始遍历，一直遍历到最后才能够拿到最后一个节点的数据(。而循环双向链表会把header的prev指向最后一个节点，最后一个节点next指向header  时间复杂度：O(n))
	 * @param index
	 * @return
	 */
	public DNode<T> getNode(int index){
		if (index<0 || index>=mCount){
			throw new IndexOutOfBoundsException();
		}

		//正向查找
		if (index <= mCount/2){
			DNode next = headNode.next;
			for (int i = 0; i < index; i++) {
				 next = next.next;
			}
			return next;
		}

		DNode pre = headNode.pre;
		for (int i = 0; i < mCount-index+1; i++) {
			 pre = pre.pre;
		}
		return pre;
	}

	/**
	 * 查询第一个节点的值
	 * @return
	 */
	public T getFirst(){
		return getNode(0).value;
	}

	/**
	 * 查询最后一个节点的值
	 * @return
	 */
	public T getLast(){
		return getNode(mCount-1).value;
	}

	/**
	 * 获取第index位置的节点的值
	 * @return
	 */
	public T getLast(int index){
		return getNode(index).value;
	}

	public void insert(int index, T obj){

	}

}
