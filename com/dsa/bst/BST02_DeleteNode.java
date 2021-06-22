package com.dsa.bst;

import java.util.LinkedList;
import java.util.Queue;



public class BST02_DeleteNode {

	Node root;

	public static void main(String[] args) {



		BST02_DeleteNode tree = new BST02_DeleteNode();
		tree.root = new Node(5);
		tree.root.left = new Node(2);
		tree.root.right = new Node(12);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);
		tree.root.right.left = new Node(9);
		tree.root.right.right = new Node(21);
		tree.root.right.right.left = new Node(19);
		tree.root.right.right.right = new Node(25);
		tree.root.right.right.left.left = new Node(17);


		System.out.println("Before Deletion of a node - binary tree is - ");
		tree.printLevelOrder();
		System.out.println();
		System.out.println("After Deletion of a node - binary tree is - ");

		tree.root = deleteNode(tree.root,12);
		tree.printLevelOrder();

	}

	private static Node deleteNode(Node root2,int key) {
		
		if(root2==null)
			return null;
		
		if(root2.data>key)
			root2.left = deleteNode(root2.left,key);
		else if(root2.data<key)
			root2.right = deleteNode(root2.right,key);
		else {
			
			if(root2.left == null)
				return root2.right;
			else if(root2.right == null)
				return root2.left;
			else {
				
				Node successor = getSuccessor(root2);
				root2.data = successor.data;
				
				root2.right = deleteNode(root2.right,successor.data);
			}
		}
		return root2;
	}


	private static Node getSuccessor(Node root2) {
		
		Node current = root2.right;
		
		while(current!=null && current.left!=null) {
			current = current.left;
		}
		return current;
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
