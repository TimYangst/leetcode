package q107_btlotII;

import java.util.ArrayList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	private void search(TreeNode root,ArrayList<ArrayList<Integer>> rst , int level)
	{
		if (root == null) return;
		if (rst.size() == level) rst.add(0,new ArrayList<Integer>());
		rst.get(rst.size() - level- 1 ).add(root.val);
		search(root.left,rst, level+1);
		search(root.right,rst,level+1);
		
	}
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		search(root,rst,0);
		return rst;
	}
}