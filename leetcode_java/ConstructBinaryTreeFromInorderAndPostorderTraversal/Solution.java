package ConstructBinaryTreeFromInorderAndPostorderTraversal;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTree(inorder,0,postorder,0,inorder.length);
	}

	private TreeNode buildTree(int[] inorder, int b1, int[] postorder, int b2,
			int length) {
		if (length == 0) return null;
		TreeNode root = new TreeNode(postorder[b2 + length -1]);
		if (length == 1){
			root.left = root.right = null;
			return root;
		} 
		int i = b1;
		while (inorder[i] != postorder[b2 + length -1]) i++;
		root.left = buildTree(inorder, b1, postorder, b2, i - b1);
		root.right =  buildTree(inorder, i+1, postorder, b2 + (i -b1), length - (i -b1) -1);
		return root;
	}
}