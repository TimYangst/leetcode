package PathSumII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	 
public class Solution {
	private void find(TreeNode root, int sum , List<Integer> path, ArrayList<ArrayList<Integer>>rst)
	{
		if (root == null) return ;
		if (root.left == null && root.right == null)
		{
			if (sum ==  root.val){
				ArrayList<Integer> ele = new ArrayList<Integer>();
				ele.addAll(path);
				ele.add(root.val);
				rst.add(ele);
			}
			return;
		}
		path.add(root.val);
		if (root.left != null) find(root.left,sum- root.val,path,rst);
		if (root.right != null) find(root.right,sum- root.val, path,rst);
		path.remove(path.size()-1);
	}
	public ArrayList<ArrayList<Integer>>  pathSum(TreeNode root,  int sum) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (root == null) return rst;
        find(root,sum,new LinkedList<Integer>(),rst);
        return rst;
    }
}