package com.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;



public class BT22_CheckSumTree {

	Node root;

	public static void main(String[] args) {

		BT22_CheckSumTree tree = new BT22_CheckSumTree();
		tree.root = new Node(5);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);

		System.out.println("Before Sum Tree of binary tree is - ");
		tree.printLevelOrder();
		System.out.println();
		System.out.println("After Sum Tree of binary tree is - ");
		int result = checkSumTree(tree.root);
		if(result!=0)
			System.out.println("The given tree is a SumTree");
		else
			System.out.println("The given tree is not a SumTree");
		
	}

	private static int checkSumTree(Node root) {
		
		if(null==root)
			return 0;
		if(root.left==null && root.right==null)
			return root.data;
		int left = checkSumTree(root.left);
		int right = checkSumTree(root.right);

		if(root.data!=left + right)
			return 0;
		return root.data + left + right;
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
