package com.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;



public class BT23_LeafAtSameLevel {

	Node root;
	static boolean result = true;
	static int level = -1;
	
	public static void main(String[] args) {

		
		BT23_LeafAtSameLevel tree = new BT23_LeafAtSameLevel();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.right.right = new Node(5);

		System.out.println("Before Leaf Level -  Tree of binary tree is - ");
		tree.printLevelOrder();
		System.out.println();
		System.out.println("After Leaf Level - Tree of binary tree is - ");
		System.out.println(checkLeafAtSameLevel(tree.root));

	}

	private static boolean checkLeafAtSameLevel(Node root) {
		
		int height = 0;
		checkLeafLevelUtil(root,height);
		return result;
	}

	private static void checkLeafLevelUtil(Node root, int height) {

		if(root == null)
			return;
		if(result == false)
			return;
		if(root.left == null && root.right == null) {
			
			if(level == -1)
				level = height; // level = 2
			else if(height!= level)
				result = false;
			return;
		}
		
		checkLeafLevelUtil(root.left, height+1);
		checkLeafLevelUtil(root.right, height+1);
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
