package com.dsa.bst;

import java.util.LinkedList;
import java.util.Queue;



public class BST03_MinMax {

	Node root;

	public static void main(String[] args) {



		BST03_MinMax tree = new BST03_MinMax();
		tree.root = new Node(10);
		tree.root.left = new Node(5);
		tree.root.right = new Node(13);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(11);
		tree.root.right.right = new Node(15);


		System.out.println("Before Sum Tree of binary tree is - ");
		tree.printLevelOrder();
		System.out.println();

		
		System.out.println("Minimum Value : "+findMinValue(tree.root));
		System.out.println("Maximum Value : "+findMaxValue(tree.root));

	}

	private static int findMaxValue(Node root2) {
		
		if(root2.right == null)
			return root2.data;
		
		int right = findMaxValue(root2.right);
		
		return right;
	}

	private static int findMinValue(Node root2) {
		
		if(root2.left == null)
			return root2.data;
		
		int left = findMinValue(root2.left);
		return left;
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
