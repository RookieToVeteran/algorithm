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


	public DoubleLink() {
		headNode = new DNode<T>(null, null, null);
		headNode.next = headNode;
		mCount = 0;
	}

	/**
	 * 双向链表的节点
	 */
	class DNode<T> {
		public DNode pre;
		public DNode next;
		public T value;

		DNode(DNode pre, DNode next, T value) {
			this.pre = pre;
			this.next = next;
			this.value = value;
		}
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

		DNode next = headNode.next;
		for (int i = 0; i < index; i++) {
			next = next.next;
		}
		return next;
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
	public T getIndex(int index){
		return getNode(index).value;
	}

	/**
	 * 在index位置插入节点
	 * @param index
	 * @param obj
	 */
	public void insert(int index, T obj){
		if (index<0){
			throw new IndexOutOfBoundsException();
		}
//		//DESC 第一个位置
		if (index==0){
			DNode next = headNode.next;
			DNode<T> firstNode = new DNode<>(headNode, next, obj);
			headNode.next = firstNode;
			next.pre = firstNode;
			mCount++;
			return;
		}

		DNode<T> node = getNode(index);
		DNode next = node.next;
		DNode<T> lastNode = new DNode<>(node, next, obj);
		node.next = lastNode;
		mCount++;
		return;

	}

	/**
	 * 将元素插入第一个节点
	 * @param obj
	 */
	public void insertFirst(T obj){
		insert(0,obj);
	}

	/**
	 * 追加到最后一个节点
	 * @param obj
	 */
	 public void appendLast(T obj){
		insert(mCount-1,obj);
	 }

	/**
	 * 删除index处的节点
	 * @param index
	 * @return
	 */
	 public T delete(int index){
		 DNode<T> node = getNode(index);
		 DNode pre = node.pre;
		 DNode next = node.next;
		 pre.next = next;
		 next.pre = pre;
		 mCount--;
		 T value = node.value;
		 node =null;
		 return value;
	 }

	/**
	 * 删除第一个节点
	 * @return
	 */
	public T deleteFirst(){
	 	return delete(0);
	 }

	 public T deleteLast(){
		return delete(mCount-1);
	 }
}



