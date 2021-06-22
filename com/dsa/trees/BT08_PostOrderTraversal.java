package com.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class BT08_PostOrderTraversal {

	Node root;

	public static void main(String[] args) {

		BT08_PostOrderTraversal tree = new BT08_PostOrderTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Before Postorder Traversal of binary tree is - ");
		tree.printLevelOrder();
		System.out.println();
		System.out.println("After Postorder Traversal of binary tree using Iterative is - ");
		postorderTraversalByIterative(tree.root);
		System.out.println();
		System.out.println("After Postorder Traversal of binary tree using Recurssion is - ");
		postorderTraversalByRecurssion(tree.root);
		
	}
	
	// Left Right Vertex - LRV
	private static void postorderTraversalByRecurssion(Node root2) {
		
		if(root2==null)
			return;
		postorderTraversalByRecurssion(root2.left);
		postorderTraversalByRecurssion(root2.right);
		System.out.print(root2.data+" ");
	}

	private static void postorderTraversalByIterative(Node root) {
		
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		
		Stack<Integer> result = new Stack<>();
		
		while(!stack.isEmpty()) {
			Node temp = stack.pop();
			result.push(temp.data);
			
			if(temp.left!=null)
				stack.push(temp.left);
			if(temp.right!=null)
				stack.push(temp.right);
		}
		
		while(!result.isEmpty())
			System.out.print(result.pop()+" ");
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
