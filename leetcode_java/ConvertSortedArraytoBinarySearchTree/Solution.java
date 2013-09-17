package ConvertSortedArraytoBinarySearchTree;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	private TreeNode build(int[] num,int b,int e)
	{
		if (b >= e) return null;	
		int mid= (b + e)/2;
		TreeNode root =  new TreeNode(num[mid]);
		root.left =  build(num,b,mid);
		root.right = build(num,mid+1,e);
		return root;
	}
	public TreeNode sortedArrayToBST(int[] num) {
		return build(num,0,num.length);
	}
}