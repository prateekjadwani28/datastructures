package com.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;



public class BT01_LevelOrderTraversal {

	Node root;

	public static void main(String arg[]) {

		BT01_LevelOrderTraversal tree = new BT01_LevelOrderTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);


		System.out.println("Level order traversal of binary tree is - ");
		tree.printLevelOrder();

	}

	private void printLevelOrder() {

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
