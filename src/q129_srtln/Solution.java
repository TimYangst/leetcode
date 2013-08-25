package q129_srtln;

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	public class Solution {
		
		public int sum(TreeNode root, int top)
		{
			if (root == null) return top;
			if (root.left == null && root.right == null)
			{
				return top * 10  + root.val;
			}
			int sum = 0;
			if (root.left != null) sum += sum(root.left, top * 10 + root.val);
			if (root.right != null) sum +=  sum(root.right, top * 10 + root.val);
			return sum;
		}
	    public int sumNumbers(TreeNode root) {
	    	return sum(root,0);
	        
	    }
	}