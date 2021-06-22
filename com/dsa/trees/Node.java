package com.dsa.trees;


public class Node{

	int data;
	Node left;
	Node right;

	public Node(int item) {
		this.data = item;
		left = null;
		right = null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
	
	
}