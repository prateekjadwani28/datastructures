package com.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;


public class BT14_BalanceHeightedTree {

	Node root;
	static boolean flag = true;
	public static void main(String[] args) {


		BT14_BalanceHeightedTree tree = new BT14_BalanceHeightedTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.right.left = new Node(6);
		
		System.out.println();
		System.out.println(IsBalancedTree(tree.root));
	}
	

	private static boolean IsBalancedTree(Node root2) {
		
		if(root2 == null)
			return true;
		
		int leftHeight = findHeightByRecursion(root2.left);
		int rightHeight = findHeightByRecursion(root2.right);
		
		if(Math.abs(leftHeight-rightHeight)<=1) {
			return true;
		}
		return false;
	}


	private static int findHeightByRecursion(Node rootNode) {
		
		if(rootNode == null)
			return -1;
		
		int leftHeight = findHeightByRecursion(rootNode.left);
		int rightHeight = findHeightByRecursion(rootNode.right);
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	
	public static int checkBalanced(Node root) {
		if(root == null) {
			return 0;
		}
		int x = checkBalanced(root.left);
		int y = checkBalanced(root.right);
		if(Math.abs(x-y) > 1) {
			flag = false;
		}
		
		return (Math.max(x, y) + 1);
	}
	
	public static boolean func(Node root) {
		checkBalanced(root);
		return flag;
	}

}
