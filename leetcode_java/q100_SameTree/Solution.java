package q100_SameTree;

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	public class Solution {
	    public boolean isSameTree(TreeNode p, TreeNode q) {
	    	TreeNode q2 = q;
			TreeNode p2 = p;
			if (p2 == null && q2 ==null) return true;
	    	if (p2 == null || q2 == null) return false;
	    	if (p2.val != q2.val) return false;
	    	if (!isSameTree(p2.left, q2.left)) return false;
	    	if (!isSameTree(p2.right, q2.right)) return false;
	        return true;
	    }
	}