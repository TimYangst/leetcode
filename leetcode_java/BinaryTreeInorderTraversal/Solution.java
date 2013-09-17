package BinaryTreeInorderTraversal;

import java.util.ArrayList;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Solution {
	
	private void inorderTravel(TreeNode root, ArrayList<Integer> rst)
	{
		if (root == null) return;
		if (root.left != null) inorderTravel(root.left, rst);
		rst.add(root.val);
		if (root.right != null) inorderTravel(root.right, rst);
	}
   public ArrayList<Integer> inorderTraversal(TreeNode root) {
	   ArrayList<Integer> rst = new ArrayList<Integer>();
	   if (root == null) return rst;
	   inorderTravel(root,rst);
       return rst;
   }
}