package RecoverBinarySearchTree;

class TreeNode {
	int val;
	TreeNode left =null;
	TreeNode right = null;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {

	private void search(TreeNode root, TreeNode[] prev, TreeNode[] point) {
		if (root == null)
			return;
		search(root.left, prev, point);
		if (prev[0] != null && prev[0].val > root.val) {
			if (point[0] == null) {
				point[0] = prev[0];
			}
			point[1] = root;
		}
		prev[0] = root;
		search(root.right, prev, point);
	}

	public void recoverTree(TreeNode root) {
		TreeNode[] point = new TreeNode[2];
		TreeNode[] prev = new TreeNode[1];
		prev[0] = null;
		point[0] = point[1] = null;
		search(root, prev, point);
		int tmp = point[0].val;
		point[0].val = point[1].val;
		point[1].val = tmp;
	}

	public static void main(String[] args) {
		TreeNode  root= new TreeNode(2);
		TreeNode right =  new TreeNode(1);
		root.right = right;
		new Solution().recoverTree(root);
	}
}