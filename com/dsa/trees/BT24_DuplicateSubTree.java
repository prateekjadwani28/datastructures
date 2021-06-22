package com.dsa.trees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;



public class BT24_DuplicateSubTree {

	Node root;

	public static void main(String[] args) {

		BT24_DuplicateSubTree tree = new BT24_DuplicateSubTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		
		tree.root.right.right = new Node(2);
		tree.root.right.right.left = new Node(4);
		tree.root.right.right.right = new Node(5);
		

		System.out.println("Before mirror of binary tree is - ");
		tree.printLevelOrder();
		System.out.println();
		String result = isDuplicateSubTreePresent(tree.root);
		if(result.equals(""))
			System.out.println("YES");
		else
			System.out.println("NO");
		
	}

	private static String isDuplicateSubTreePresent(Node root2) {
		Set<String> set = new HashSet<>();
		return dupSubTreeUtil(root2,set);
	}

	private static String dupSubTreeUtil(Node root, Set<String> set) {
		
		String temp = "";
		
		if(root == null)
			return temp + "$";
		
		String left = dupSubTreeUtil(root.left, set);
		if(left.equals(temp))
			return temp;
		
		String right = dupSubTreeUtil(root.right, set);
		if(right.equals(temp))
			return temp;
		
		temp = temp + root.data + left + right;
		
		if(temp.length()>3 && set.contains(temp))
			return "";
		set.add(temp);
		
		return temp;
		
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
