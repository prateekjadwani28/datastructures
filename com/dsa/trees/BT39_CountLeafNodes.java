package com.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BT39_CountLeafNodes {

	Node root;
	static int count = 0;
	public static void main(String[] args) {

		BT39_CountLeafNodes tree = new BT39_CountLeafNodes();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.right.left = new Node(6);

		System.out.println("Binary tree is - ");
		tree.printLevelOrder();
		System.out.println();

		countLeafNodes(tree.root);

		System.out.println("Number of leaf nodes are : " +count);
	
	}
	
	private static void countLeafNodes(Node root2) {
 
		if(root2 == null)
			return;
		
		if(root2.left == null && root2.right == null)
			count++;
		
		countLeafNodes(root2.left);
		countLeafNodes(root2.right);
	}

	private void printLevelOrder() {

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			System.out.print(temp.data + " ");
			
			if(temp.left!=null)
				queue.add(temp.left);
			if(temp.right!=null)
				queue.add(temp.right);
		}
	}

}
