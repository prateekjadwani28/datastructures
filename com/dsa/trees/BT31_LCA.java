package com.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;



public class BT31_LCA {

	Node root;

	public static void main(String[] args) {

		BT31_LCA tree = new BT31_LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Before Sum Tree of binary tree is - ");
		tree.printLevelOrder();
		System.out.println();
		System.out.println("After Sum Tree of binary tree is - ");
		Node result = findLca(tree.root, 4,5);
		if(result!=null)
			System.out.println(result.data);
		else
			System.out.println("False");
	}

	/*
	 * Lowest Common Ancestor : The idea is to traverse the tree starting from the root. 
	 * If any of the given keys (n1 and n2) matches with the root, then the root is LCA.
	 * 
	 * We will find the keys on the left and right side of a node, if there are no value at either side then 
	 * we will send null. 
	 * 
	 * if there is no value at one side, we will be sending null and will check the other side. Wherever we get the first node as one of the keys, return that as LCA
	 * 
	 * if there are both the values on either sides of a node, then the root node is the LCA 
	 * 
	 * 
	 * */
	private static Node findLca(Node root2, int i, int j) {
		
		if(root2 == null)
			return null;
		if(root2.data == i || root2.data == j)
			return root2;
		
		Node left = findLca(root2.left,i,j);
		Node right = findLca(root2.right,i,j);
		
		if(left!= null && right!=null)
			return root2;
		if(left!=null)
			return left;
		else
			return right;
		
	}

	private  void printLevelOrder() {

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {

			Node temp = queue.poll();
			System.out.print(temp.data + " ");

			if(null!=temp.left)
				queue.add(temp.left);
			if(null!=temp.right)
				queue.add(temp.right);
		}

	}
}
