package q114_FlattenBinaryTreetoLinkedList;

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	public class Solution {
	    public void flatten(TreeNode root) {
	    	if (root == null) return;
	    	if (root.left == null && root.right == null) return;
	    	if (root.left == null){
	    		flatten(root.right);
	    		return;
	    	}
	    	if (root.right == null){
	    		flatten(root.left);
	    		root.right = root.left;
	    		root.left = null;
	    		return;
	    	}
	    	TreeNode p = root.left;
	    	while (p.right != null || p.left != null){
	    		if (p.right != null) p = p.right;
	    		else p = p.left;
	    	} 
	    	flatten(root.left);
	    	flatten(root.right);
	    	p.right = root.right;
	    	root.right =  root.left;
	    	root.left = null;
	    }
	}