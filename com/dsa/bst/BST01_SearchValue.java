package com.dsa.bst;

import java.util.LinkedList;
import java.util.Queue;



public class BST01_SearchValue {

	Node root;

	public static void main(String[] args) {



		BST01_SearchValue tree = new BST01_SearchValue();
		tree.root = new Node(10);
		tree.root.left = new Node(5);
		tree.root.right = new Node(13);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(6);
		tree.root.right.left = new Node(11);
		tree.root.right.right = new Node(15);


		System.out.println("Binary tree is - ");
		tree.printLevelOrder();
		System.out.println();
		int k = 13;
		System.out.println("Is "+ k +" present in BST : "+isNodePresent(tree.root,k));

	}

	private static boolean isNodePresent(Node root2,int key) {

		if(root2==null)
			return false;
		if(root2.data==key)
			return true;

		if(key < root2.data) 
			return isNodePresent(root2.left, key);

		else 
			return isNodePresent(root2.right, key);
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
