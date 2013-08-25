package q124_btmps;

class TreeNode {
     int val;
     TreeNode left = null;
     TreeNode right = null;
     TreeNode(int x) { val = x; }
 }

public class Solution {
	int _max = Integer.MIN_VALUE;
	
	private int maxpath(TreeNode root)
	{
		if (root == null) return 0;
		//if (root.right ==root.left) return root.val;
		
		int maxl = root.left == null? 0 : maxpath(root.left);
		int maxr = root.right == null?0 : maxpath(root.right);
		
		if (maxl < 0 ) maxl = 0;
		if (maxr < 0) maxr = 0;
		
		if (root.val + maxl + maxr > _max)
		{
			 _max = root.val + maxl+ maxr;
		}
		return root.val + Math.max(maxl, maxr);
		
	}
   public int maxPathSum(TreeNode root) {
	   if (root == null) return 0;
	   //if (root.left == root.right) return root.val;
	   maxpath(root);
	   
       return _max;
   }
   
   public static void main(String[] args) {
	   System.out.println(new Solution().maxPathSum(new TreeNode(-3)));
	   
   }
}