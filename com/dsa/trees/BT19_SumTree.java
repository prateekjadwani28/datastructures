package com.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;



public class BT19_SumTree {

	Node root;

	public static void main(String[] args) {

		BT19_SumTree tree = new BT19_SumTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Before Sum Tree of binary tree is - ");
		tree.printLevelOrder();
		System.out.println();
		System.out.println("After Sum Tree of binary tree is - ");
		sumTree(tree.root);
		tree.printLevelOrder();

	}

	private static int sumTree(Node root) {

		if(null==root)
			return 0;
		int left = sumTree(root.left);
		int right = sumTree(root.right);

		int prev = root.data;

		root.data = left + right;

		return prev + left + right;
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
