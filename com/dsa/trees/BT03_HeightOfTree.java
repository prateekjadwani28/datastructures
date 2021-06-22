package com.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;


public class BT03_HeightOfTree {

	Node root;
	public static void main(String[] args) {


		BT03_HeightOfTree tree = new BT03_HeightOfTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.right.right = new Node(6);
		
		System.out.println("Height of a tree is : "+findHeightByRecursion(tree.root));
		//System.out.println(findHeightByIterative(tree.root));
	}
	
	private static int findHeightByIterative(Node rootNode) {

		Queue<Node> queue = new LinkedList<>();
		queue.add(rootNode);
		int size = 1,height = 0;
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();

			if(null!=temp.left) {
				queue.add(temp.left);
			}
			
			if(null!=temp.right) {
				queue.add(temp.right);
			}
			
			size--;
			if(size==0) {
				height++;
				size = queue.size();
			}
		}
		
		return height-1;
	}

	private static int findHeightByRecursion(Node rootNode) {
		
		if(rootNode == null)
			return -1;
		
		int leftHeight = findHeightByRecursion(rootNode.left); 
		int rightHeight = findHeightByRecursion(rootNode.right);
		
		return Math.max(leftHeight, rightHeight) + 1;
	}

}
