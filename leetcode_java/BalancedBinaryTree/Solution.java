package BalancedBinaryTree;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	private int getHight(TreeNode root)
	{
		if (root == null) return 0;
		return (1 + Math.max(getHight(root.left),getHight(root.right)));
	}
	
	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		int leftHight = getHight(root.left);
		int rightHight = getHight(root.right);
		if (Math.abs(leftHight -  rightHight) > 1) return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}
}