package q109_bbt;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class Data {
	boolean isBalanced = true;
	int l = 0;
	int d = 0;
}

public class Solution {
	private int getlow(TreeNode root)
	{
		if (root == null) return 0;
		return Math.min(getlow(root.left),getlow(root.right)) +1;
	}
	
	private int getdeep(TreeNode root)
	{
		if (root == null) return 0;
		return Math.max(getdeep(root.left),getdeep(root.right)) +1;
	}
    public boolean isBalanced(TreeNode root) {
    	if (root == null) return true;
    	if (root.left == null)
    	return ll  >= Math.max(dr, dl) -1;
    }
}