package q98_vbst;

import java.util.LinkedList;
import java.util.List;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }


public class Solution {
	private void midTravel(TreeNode root,List<Integer> rst)
	{
		if (root.left != null) midTravel(root.left, rst);
		rst.add(root.val);
		if (root.right !=null) midTravel(root.right, rst);
		
	}
   public boolean isValidBST(TreeNode root) {
	  if (root == null) return true;
	  List<Integer> midt = new LinkedList<Integer>();
	  midTravel(root,midt);
	  int front = midt.get(0)-1;
	  for (int ele : midt)
	  {
		  if (front >= ele) return false;
		  front = ele;
	  }
      return true; 
   }
}