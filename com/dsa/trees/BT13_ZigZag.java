package com.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class BT13_ZigZag {

	Node root;

	public static void main(String[] args) {

		BT13_ZigZag tree = new BT13_ZigZag();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Before ZigZag View of binary tree is - ");
		tree.printLevelOrder();
		System.out.println();
		System.out.println("After ZigZag View of binary tree using Iterative is - ");
		zigzag(tree.root);
		System.out.println();
		//System.out.println("After ZigZag View of binary tree using Recurssion is - ");
		//zigZagViewByRecurssion(tree.root);


	}

	/*private static void zigZagViewByRecurssion(Node root2) {

		if(root2==null)
			return;
		System.out.print(root2.data+" ");
		zigZagViewByRecurssion(root2.right);
		zigZagViewByRecurssion(root2.left);
	}*/
	
	private static void zigzag(Node parent) {
		Stack<Node> p = new Stack<>();
		Stack<Node> c = new Stack<>();
		p.push(parent);
		int level = 0;
		while (!p.isEmpty()) {
			Node node = p.pop();
			System.out.print(node.data + " ");
			if (level % 2 == 0) {
				if (node.left != null) {
					c.push(node.left);
				}
				if (node.right != null) {
					c.push(node.right);
				}
			} else {
				if (node.right != null) {
					c.push(node.right);
				}
				if (node.left != null) {
					c.push(node.left);
				}
			}
			if (p.size() == 0) {
				level++;
				p = c;
				c = new Stack<>();
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
