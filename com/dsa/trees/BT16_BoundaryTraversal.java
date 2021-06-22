package com.dsa.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BT16_BoundaryTraversal {

	Node root;
	public static void main(String[] args) {


		BT16_BoundaryTraversal tree = new BT16_BoundaryTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.right.left = new Node(7);
		tree.root.left.right = new Node(9);
		tree.root.right.right = new Node(8);
		tree.root.right.right.right = new Node(10);
		tree.root.left.left = new Node(4);
		tree.root.left.left.right = new Node(5);
		tree.root.left.left.right.left = new Node(6);

		System.out.println("Before Boundary Traversal of binary tree is - ");
		tree.printLevelOrder();
		System.out.println();
		System.out.println("After Boundary Traversal of binary tree using Iterative is - ");
		printBoundaryTraversalUsingRecursion(tree.root);
	}


	private static void printBoundaryTraversalUsingRecursion(Node node) {
		List<Integer> list = new ArrayList<>();
		list.add(node.data);

		printLeftNode(node.left,list);
		printLeafNode(node,list);
		printRightNode(node.right,list);

		for(int i: list)
			System.out.print(i+" ");
	}


	private static void printRightNode(Node node, List<Integer> list) {

		if(node==null)
			return;
		if(node.right!=null) {
			printRightNode(node.right, list);
			list.add(node.data);
		}
		else if(node.left!=null) {
			printRightNode(node.left, list);
			list.add(node.data);
		}
	}


	private static void printLeafNode(Node node, List<Integer> list) {
		if(node==null)
			return;
		printLeafNode(node.left, list);
		if(node.left==null && node.right==null)
			list.add(node.data);
		printLeafNode(node.right, list);

	}


	private static void printLeftNode(Node node, List<Integer> list) {

		if(node==null)
			return;
		if(node.left!=null) {	
			list.add(node.data);
			printLeftNode(node.left, list);
		}
		else if(node.right!=null) {
			list.add(node.data);
			printLeftNode(node.right, list);
		}
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
