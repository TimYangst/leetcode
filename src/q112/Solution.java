package q112;

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 
	public class Solution {
	    public boolean hasPathSum(TreeNode root, int sum) {
	    	if (root == null) return false;
	    	if (root.left == null && root.right == null) return (root.val == sum);
	    	if (root.left != null && hasPathSum(root.left, sum - root.val)) return true;
	    	if (root.right != null && hasPathSum(root.right, sum -root.val)) return true;
	      return false;
	      
	    }
	}