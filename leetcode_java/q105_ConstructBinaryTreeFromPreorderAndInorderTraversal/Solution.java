package q105_ConstructBinaryTreeFromPreorderAndInorderTraversal;
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Solution {
   public TreeNode buildTree(int[] preorder, int[] inorder) {
       return buildTree(preorder,0,inorder,0,preorder.length);
   }
	private TreeNode buildTree(int[] preorder, int b1, int[] inorder,int b2, int length) {
		if (length == 0) return null;
		TreeNode root = new TreeNode(preorder[b1]);
		if (length == 1)	{
			root.left = root.right =null;
			return root;
		}
		int i = b2;
		while (inorder[i] != preorder[b1]) i++;
		root.left = buildTree(preorder, b1+1,inorder,b2,i-b2);
		root.right = buildTree(preorder,b1+(i-b2)+1,inorder,i+1,length-(i-b2) -1);
		return root;
	}
}