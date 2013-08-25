package q102_BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
  class TreeNode {
	     int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	public class Solution {
		private void search(TreeNode root, int level,ArrayList<ArrayList<Integer>> rst)
		{
			if (root ==  null) return;
			if (rst.size()  == level)
			{
				ArrayList<Integer> ele = new ArrayList<Integer>();
				rst.add(ele);
			}
			rst.get(level).add(root.val);
			if (root.left != null) search(root.left,level+1, rst);
			if (root.right != null) search(root.right,level+1,rst);
		}
		
	    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
	    	ArrayList<ArrayList<Integer>> rst=  new ArrayList<ArrayList<Integer>>();
	    	if (root== null) return rst;
	    	search(root,0,rst);
	    	return rst;
	        
	    }
	}