package q109_ConvertSortedListtoBinarySearchTree;
class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; next = null; }
	  }
	 
	
	 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

	 
	public class Solution {
		
		private TreeNode build(ListNode list,int l){
			if (l == 0) return null;
			if (l == 1) {
				TreeNode root = new TreeNode(list.val);
				pn= list.next;
				
				root.right = null;
				root.left = null;
				return root;
			}
			int mid = l / 2;
			TreeNode leftc = build(list, mid);
			TreeNode root = new TreeNode(pn.val);
			pn = pn.next;
			root.left = leftc;
			root.right = build(pn,l - mid -1);
			return root;
		}
		
		ListNode pn = null;
		
	    public TreeNode sortedListToBST(ListNode head) {
	       ListNode p = head;
	       int l =0;
	       while (p != null) {
	    	   p = p.next;
	    	   l++;
	       }
	       return build(head,l);
	       
	    }
	}