package com.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BT02_RevLevelOrderTraversal {

	Node root;

	public static void main(String[] args) {

		BT02_RevLevelOrderTraversal tree = new BT02_RevLevelOrderTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Reverse Level order traversal of binary tree is - ");
		reverseLevelTraverse(tree.root);
	}

	private static void reverseLevelTraverse(Node root) {

		Queue<Node> queue = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		queue.add(root);

		while(!queue.isEmpty()) {

			Node temp = queue.poll();
			stack.add(temp);

			if(null!=temp.right) {
				queue.add(temp.right);
			}

			if(null!=temp.left) {
				queue.add(temp.left);
			}
		}

		while(!stack.isEmpty()) {
			Node temp = stack.pop();
			System.out.print(temp.data +" ");
		}

	}

}
