package com.dsa.bst;

import java.util.LinkedList;
import java.util.Queue;



public class BST07_LowestCommonAncestor {

	Node root;

	public static void main(String[] args) {

		BST07_LowestCommonAncestor tree = new BST07_LowestCommonAncestor();
		tree.root = new Node(10);
		tree.root.left = new Node(5);
		tree.root.right = new Node(13);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(11);
		tree.root.right.right = new Node(15);

		System.out.println("Before Sum Tree of binary tree is - ");
		tree.printLevelOrder();
		System.out.println();
		System.out.println("After Sum Tree of binary tree is - ");
		Node result = findLca(tree.root, 15 ,5);
		System.out.println(result.data);
	}

	/*
	 * Lowest Common Ancestor : The idea is to traverse the tree starting from the root. 
	 * If any of the given keys (n1 and n2) matches with the root, then the root is LCA.
	 * 
	 * We will find the keys on the left and right side of a node, if there are no value at either side then 
	 * we will send root. 
	 * 
	 * if there is no value at one side, we will be sending null and other node has other value then we will send 
	 * other node as it would act as LCA.
	 * 
	 * if there are both the values on either sides of a node, then the root node is the LCA 
	 * 
	 * 
	 * */
	private static Node findLca(Node root2, int i, int j) {
		
		if(root2 == null)
			return null;
		if(root2.data == i || root2.data == j)
			return root2;
		
		Node left = findLca(root2.left,i,j);
		Node right = findLca(root2.right,i,j);
		
		if(left!= null && right!=null)
			return root2;
		if(left!=null)
			return left;
		else
			return right;
		
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
