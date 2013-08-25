package q116_pnrpen;

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}


public class Solution {
	private void connectNode(TreeLinkNode root)
	{
		TreeLinkNode node =  root.next;
		TreeLinkNode next =  null;
		if (node != null) next = node.left;
		root.right.next = next;
		root.left.next = root.right;
		if (root.right.left != null)
		{
			connectNode(root.right);
			connectNode(root.left);
		}
	}
	public void connect(TreeLinkNode root) {
		if (root == null) return;
		root.next = null;
		if (root.right != null) 
		{
			root.right.next = null;
			root.left.next = root.right;
			if (root.right.left != null)
			{
				connectNode(root.right);
				connectNode(root.left);
			}
		} 
			
	}
}