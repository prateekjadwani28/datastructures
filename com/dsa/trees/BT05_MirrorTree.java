package com.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;



public class BT05_MirrorTree {

	Node root;

	public static void main(String[] args) {

		BT05_MirrorTree tree = new BT05_MirrorTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Before mirror of binary tree is - ");
		tree.printLevelOrder();
		System.out.println();
		System.out.println("After mirror of binary tree is - ");
		mirrorOfTree(tree.root);
		tree.printLevelOrder();
		
	}

	private static Node mirrorOfTree(Node root) {
		
		if(null==root)
			return root;
		Node left = mirrorOfTree(root.left);
		Node right = mirrorOfTree(root.right);
		
		root.right = left;
		root.left = right;
		
		return root;
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
