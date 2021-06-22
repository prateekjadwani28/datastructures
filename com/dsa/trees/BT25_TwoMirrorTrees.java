package com.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;



public class BT25_TwoMirrorTrees {

	Node root;

	public static void main(String[] args) {

		BT25_TwoMirrorTrees tree1 = new BT25_TwoMirrorTrees();
		tree1.root = new Node(1);
		tree1.root.left = new Node(2);
		tree1.root.right = new Node(3);
		tree1.root.left.left = new Node(4);
		tree1.root.left.right = new Node(5);

		
		BT25_TwoMirrorTrees tree2 = new BT25_TwoMirrorTrees();
		tree2.root = new Node(1);
		tree2.root.left = new Node(3);
		tree2.root.right = new Node(2);
		tree2.root.right.left = new Node(5);
		tree2.root.right.right = new Node(4);
		
		
		System.out.println("Before Mirror View of binary tree is - ");
		tree1.printLevelOrder();
		System.out.println();
		tree2.printLevelOrder();
		
		System.out.println();
		System.out.println("After Left View of binary tree using Iterative is - ");
		System.out.println(checkMirrorByRecurssion(tree1.root,tree2.root));
		System.out.println();

	}
	
	/*
	 * Find the inorder traversal of both the Binary Trees, and check whether one traversal
	 *  is reverse of another or not. If they are reverse of each other then the trees are mirror of each other, else not 
	 * 
	 * */

	private static boolean checkMirrorByRecurssion(Node root1,Node root2) {

		if(root1==null && root2==null)
			return true;

		if(root1==null || root2==null)
			return false;
		
		return root1.data == root2.data && checkMirrorByRecurssion(root1.left, root2.right) 
				&& checkMirrorByRecurssion(root1.right, root2.left);

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
