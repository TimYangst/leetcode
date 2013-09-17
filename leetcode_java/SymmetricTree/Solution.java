package SymmetricTree;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Solution {
   public boolean isSymmetric(TreeNode root) {
	   if (root  == null) return true;
	   if (root.left == null && root.right == null) return true;
	   if (root.left == null || root.right == null) return false;
	   if (root.left.val != root.right.val) return false;
	   TreeNode node =  new TreeNode(0);
	   node.left =  root.left.left;
	   node.right = root.right.right;
	   if (!isSymmetric(node)) return false;
	   node.left =  root.left.right;
	   node.right = root.right.left;
	   if (!isSymmetric(node)) return false;
	   return true;
   }
}