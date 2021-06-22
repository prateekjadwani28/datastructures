package com.dsa.bst;

import java.util.Stack;

public class BST19_ValidPreorder {

	Node root;
	static int count = 0;

	public static void main(String[] args) {

		int preorder [] = {40,30,35,20,80,100}; 
		//VLR
		System.out.println(checkPreoder(preorder,preorder.length));
	}

	private static boolean checkPreoder(int[] preorder, int n) {

		Stack<Integer> stack = new Stack<>();
		int root = Integer.MIN_VALUE;

		for(int i=0;i<n;i++) {

			if(preorder[i] < root)
				return false;
			while(!stack.empty() && stack.peek()<preorder[i]) {

				root = stack.peek(); // 30
				stack.pop(); // stack = 40
			}
			stack.push(preorder[i]); // 40 35
		}
		return true;
	}

	private static  void inorderTraversal(Node root) {

		if(root == null)
			return;

		inorderTraversal(root.left);
		System.out.print(root.data+" ");
		inorderTraversal(root.right);

		return;
	}

}
