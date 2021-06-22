package com.dsa.leet.medium;

import com.dsa.bst.Node;

public class LT12_ConvertArrayToBST {

	public static void main(String[] args) {

		int nums[] = {2,3,4,5,6,7,8};
		Node root = conversionToBst(nums,0,nums.length-1);
		preOrderTraversal(root);
	}

	private static Node conversionToBst(int[] nums, int start, int end) {
		
		if(start > end)
			return null;
		int mid = (start+end)/2;
		Node node = new Node(nums[mid]);
		
		node.left = conversionToBst(nums, start, mid-1);
		node.right = conversionToBst(nums, mid+1, end);
		
		return node;
	}
	
	private static void preOrderTraversal(Node root) {
		
		if(root == null)
			return;
		
		System.out.print(root.data+" ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
		
		return;
	}

}
