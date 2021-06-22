package com.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class BT07_PreOrderTraversal {

	Node root;

	public static void main(String[] args) {

		BT07_PreOrderTraversal tree = new BT07_PreOrderTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Before Preorder Traversal of binary tree is - ");
		tree.printLevelOrder();
		System.out.println();
		System.out.println("After Preorder Traversal of binary tree using Iterative is - ");
		inorderTraversalByIterative(tree.root);
		System.out.println();
		System.out.println("After Preorder Traversal of binary tree using Recurssion is - ");
		preorderTraversalByRecurssion(tree.root);
		
	}
	
	// Vertex Left Right  - VRL
	private static void preorderTraversalByRecurssion(Node root2) {
		
		if(root2==null)
			return;
		System.out.print(root2.data+" ");
		preorderTraversalByRecurssion(root2.left);
		preorderTraversalByRecurssion(root2.right);
	}

	/*
	 * 
	 * 1. Push the root element in the stack
	 * 2. While (stack is not empty)
	 * 		2.a print the current element
	 * 		2.b store the current's right element in the stack
	 * 		2.c move current to left 
	 * 		2.d current is null, pop stack element i.e right element stored
	 * 		Stack -> 1,3,5
	 * */
	private static void inorderTraversalByIterative(Node root) {
		
		Stack<Node> stack = new Stack<>();
		stack.add(root);
		Node current = root;
		
		while(!stack.isEmpty()) {
			
			if(current!=null) {
				System.out.print(current.data+" ");
				
				if(current.right!=null)
					stack.push(current.right);
				
				current = current.left;
			}
			else {
				current = stack.pop();
			}
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
