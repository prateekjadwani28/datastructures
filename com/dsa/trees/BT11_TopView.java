package com.dsa.trees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;



public class BT11_TopView {

	Node root;
	static int maxLevel = 0;

	public static void main(String[] args) {

		BT11_TopView tree = new BT11_TopView();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Before Top View of binary tree is - ");
		tree.printLevelOrder();
		System.out.println();
		System.out.println("After Top View of binary tree using Iterative is - ");
		topViewByIterative(tree.root);
		System.out.println();
		/*System.out.println("After Top View of binary tree using Recurssion is - ");
		topViewByRecurssion(tree.root,1);*/


	}

	private static void topViewByRecurssion(Node root2, int level) {

		if(root2==null)
			return ;

		if(maxLevel<level) {
			System.out.print(root2.data+" ");
			maxLevel = level;
		}

		topViewByRecurssion(root2.right, level+1);
		topViewByRecurssion(root2.left, level+1);

	}

	private static void topViewByIterative(Node root) {

		Queue<NodePair> queue = new LinkedList<>();
		if(root==null)
			return;
		queue.add(new NodePair(root,0));

		Map<Integer,Node> nodeMap = new TreeMap<>();

		while(!queue.isEmpty()) {
			NodePair temp = queue.poll();
			if(!nodeMap.containsKey(temp.value)) {
				nodeMap.put(temp.value, temp.node);
			}

			if(temp.node.left!=null)
				queue.add(new NodePair(temp.node.left, temp.value-1));

			if(temp.node.right!=null)
				queue.add(new NodePair(temp.node.right, temp.value+1));
		}

		for(Node node : nodeMap.values()) {
			System.out.print(node.data+" ");
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
