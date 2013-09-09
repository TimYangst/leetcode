package q95_UniqueBinarySearchTreesII;

import java.util.ArrayList;


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; left = null; right = null; }
 }

public class Solution {
	private TreeNode copy(TreeNode root, int base){
		if (root  == null) return  null;
		TreeNode node = new TreeNode(root.val + base);
		node.left =  copy(root.left, base);
		node.right =  copy(root.right, base );
		return node;
	}
    public ArrayList<TreeNode> generateTrees(int n) {
    	ArrayList<TreeNode>[] trees = new ArrayList[n +1];
    	trees[0] = 	new ArrayList<TreeNode>();
    	trees[0].add(null);
    	if (n == 0) return  trees[0];
    	trees[1] = new ArrayList<TreeNode>();
    	TreeNode node = new TreeNode(1);
    	node.left = node.right = null;
    	trees[1].add(node);
    	for (int i = 2; i <= n; i++)
    	{
    		trees[i] =  new ArrayList<TreeNode>();
    		for (int j = 1; j<= i; j++)
    		{
    			for (TreeNode left : trees[j-1]){
    				for ( TreeNode right : trees[i - j])
    				{
    					TreeNode ele =  new TreeNode(j);
    					ele.left = copy(left,0);
    					ele.right = copy(right, j);
    					trees[i].add(ele);
    				}
    			}
    		}
    	}
    	return  trees[n];
    }
}