package com.dsa.bst;

import java.util.LinkedList;
import java.util.Queue;



public class BST05_CheckBinarySearchTree {

	Node root;

	public static void main(String[] args) {



		BST05_CheckBinarySearchTree tree = new BST05_CheckBinarySearchTree();
		tree.root = new Node(10);
		tree.root.left = new Node(5);
		tree.root.right = new Node(13);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(11);
		tree.root.right.right = new Node(15);


		System.out.println("Binary Search tree is - ");
		tree.printLevelOrder();
		System.out.println();
		//System.out.println("After Sum Tree of binary tree is - ");

		System.out.println("Is given tree a BST : "+checkBST(tree.root,null,null));
	}

	private static boolean checkBST(Node root,Integer low, Integer high) {
		
		if(root == null)
			return true;
		
		if(low!=null && root.data<=low || high!=null && root.data>=high)
			return false;
		
		return checkBST(root.left, low, root.data) && checkBST(root.right, root.data, high);
		
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
