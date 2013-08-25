package q111_MinimumDepthofBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 
	public class Solution {
	    public int minDepth(TreeNode root) {
	    	if (root == null) return 0;
	       Queue<TreeNode> nodeq = new LinkedList<TreeNode>(); 
	       Queue<Integer> deepq = new  LinkedList<Integer>();
	       nodeq.add(root);
	       deepq.add(1);
	       while (true)
	       {
	    	   TreeNode node = nodeq.poll();
	    	   int dp = deepq.poll();
	    	   if (node.left == null  && node.right == null) return dp;
	    	   if (node.left != null) {nodeq.add(node.left); deepq.add(dp+1);}
	    	   if (node.right != null) {nodeq.add(node.right);deepq.add(dp+1);}
	       }
	    }
	}