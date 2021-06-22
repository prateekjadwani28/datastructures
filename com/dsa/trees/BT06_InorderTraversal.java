package com.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class BT06_InorderTraversal {

	Node root;

	public static void main(String[] args) {

		BT06_InorderTraversal tree = new BT06_InorderTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Before Inorder Traversal of binary tree is - ");
		tree.printLevelOrder();
		System.out.println();
		System.out.println("After Inorder Traversal of binary tree using Iterative is - ");
		inorderTraversalByIterative(tree.root);
		System.out.println();
		System.out.println("After Inorder Traversal of binary tree using Recurssion is - ");
		inorderTraversalByRecurssion(tree.root);
		
	}
	// Left Vetex Right - LVR
	private static void inorderTraversalByRecurssion(Node root2) {
		
		if(root2==null)
			return;
		inorderTraversalByRecurssion(root2.left);
		System.out.print(root2.data+" ");
		inorderTraversalByRecurssion(root2.right);
	}

	private static void inorderTraversalByIterative(Node root) {
		
		Stack<Node> stack = new Stack<>();
		Node current = root;
		
		while(current != null || !stack.isEmpty()) {
			
			while(current!=null) {
				stack.push(current);
				current = current.left;
			}
			
			current = stack.pop();
			System.out.print(current.data +" ");
			current = current.right;
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
