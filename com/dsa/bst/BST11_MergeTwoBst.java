package com.dsa.bst;

import java.util.ArrayList;
import java.util.List;


public class BST11_MergeTwoBst {

	Node root;
	
	public static void main(String[] args) {

		BST11_MergeTwoBst tree1 = new BST11_MergeTwoBst();
		tree1.root = new Node(10);
		tree1.root.left = new Node(5);
		tree1.root.right = new Node(13);
		tree1.root.left.left = new Node(2);
		tree1.root.left.right = new Node(6);
		tree1.root.right.left = new Node(11);
		tree1.root.right.right = new Node(15);
		
		
		BST11_MergeTwoBst tree2 = new BST11_MergeTwoBst();
		tree2.root = new Node(12);
		tree2.root.left = new Node(4);
		tree2.root.right = new Node(16);
		tree2.root.left.left = new Node(1);
		tree2.root.left.right = new Node(7);
		tree2.root.right.left = new Node(14);
		tree2.root.right.right = new Node(17);

		System.out.println("First Binary tree is - ");
		inorderTraversal(tree1.root);
		System.out.println();
		System.out.println("Second Binary tree is - ");
		inorderTraversal(tree2.root);
		System.out.println();
		System.out.println("Merged Binary tree is - ");
		Node node = mergeTwoBst(tree1.root,tree2.root);
		inorderTraversal(node);
	}

	private static Node mergeTwoBst(Node root1, Node root2) {
		
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		
		list1 = storeInorder(root1,list1);
		list2 = storeInorder(root2,list2);
		
		List<Integer> mergeList = new ArrayList<>();
	    mergeList = merge(list1,list2,mergeList);
	    
	    Node node = mergedListToBst(mergeList,0,mergeList.size()-1);
		
	    return node;
	}

	//1 2 4 5 6 7 10 11 12 13 14 15 16 17  -- 20/2 = 10
	private static Node mergedListToBst(List<Integer> mergeList, int start, int end) {

		if(start>end)
			return null;
		
		int mid = (start + end) /2;
		Node node = new Node(mergeList.get(mid));
		
		node.left = mergedListToBst(mergeList, start, mid-1);
		node.right = mergedListToBst(mergeList, mid+1, end);
		
		return node;
	}

	private static List<Integer> storeInorder(Node rootNode, List<Integer> list) {

		if(rootNode==null)
			return list;
		
		storeInorder(rootNode.left, list);
		list.add(rootNode.data);
		storeInorder(rootNode.right, list);
		
		return list;
	}
	
	private static List<Integer> merge(List<Integer> list1, List<Integer> list2, List<Integer> mergeList) {

		int i = 0;
		int j = 0;
		while(i<list1.size() && j<list2.size()) {
			
			if(list1.get(i)<list2.get(j)) {
				mergeList.add(list1.get(i));
				i++;
			}
			else {
				mergeList.add(list2.get(j));
				j++;
			}
		}
		
		while(i<list1.size()) {
			mergeList.add(list1.get(i));
			i++;
		}
		while(j<list2.size()) {
			mergeList.add(list2.get(j));
			j++;
		}
		
		return mergeList;
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
