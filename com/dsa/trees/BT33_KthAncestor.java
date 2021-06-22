package com.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;



public class BT33_KthAncestor {

	Node root;
	// temporary node to keep track of Node returned 
	// from previous recursive call during backtrack 
	static Node temp = null; 
	static int k; 

	public static void main(String[] args) {
		
		

		BT33_KthAncestor tree = new BT33_KthAncestor();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Before Sum Tree of binary tree is - ");
		tree.printLevelOrder();
		System.out.println();
		System.out.println("After Sum Tree of binary tree is - ");
		k=1;
		Node parent = findKthAncestor(tree.root,5);

		if(parent!=null)
			System.out.println(parent.data);
	}

	private static Node findKthAncestor(Node root, int node) {
		
		if(root == null)
			return null;
		
		if(root.data == node || (temp = findKthAncestor(root.left, node)) != null 
				||(temp = findKthAncestor(root.right, node)) != null) {
			
			if(k>0)
				k--;
			else if(k==0) {
				System.out.println(root.data);
				return null;
			}
			return root;
		}
		return null;
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
