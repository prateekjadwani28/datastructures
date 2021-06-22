package com.dsa.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BT15_DiagonalTraversal {

	Node root;
	public static void main(String[] args) {


		BT15_DiagonalTraversal tree = new BT15_DiagonalTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.right.left = new Node(7);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.right.left = new Node(6);

		System.out.println("Before Diagonal Traversal of binary tree is - ");
		tree.printLevelOrder();
		System.out.println();
		System.out.println("After Diagonal Traversal of binary tree using Iterative is - ");
		printDiagonalTraversalUsingIterative(tree.root);
	}


	private static void printDiagonalTraversalUsingIterative(Node node) {

		Queue<Node> queue = new LinkedList<>();
		queue.add(node);

		while(!queue.isEmpty()) {

			Node temp = queue.poll();
			System.out.print(temp.data+" ");

			while(temp!=null) {
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					System.out.print(temp.right.data+" ");
				temp = temp.right;
			}
		}
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
