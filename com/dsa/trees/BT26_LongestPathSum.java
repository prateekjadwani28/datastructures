package com.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;



public class BT26_LongestPathSum {

	Node root;

	static int maxSum=Integer.MIN_VALUE;
	static int maxLen=0;
	public static void main(String[] args) {



		BT26_LongestPathSum tree = new BT26_LongestPathSum();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(10);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Before Sum Tree of binary tree is - ");
		tree.printLevelOrder();
		System.out.println();
		System.out.println("After Sum Tree of binary tree is - ");
		findLongestPathSum(tree.root,0,0);
		System.out.println(maxSum);

	}

	private static void findLongestPathSum(Node root2,int len,int sum) {

		if(root2 == null) {
			if(maxLen<len) {
				maxLen = len;
				maxSum = sum;
			}
			else if(maxLen == len && maxSum<sum)
				maxSum = sum;
			return;
		}	
		findLongestPathSum(root2.left, len+1, sum+root2.data);
		findLongestPathSum(root2.right, len+1, sum+root2.data);
		return;

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
