package PopulatingNextRightPointersInEachNode;

import java.util.LinkedList;
import java.util.Queue;


	  public class Solution_om {	 
		    public void connect(TreeLinkNode root) {
		    	if (root == null) return;
		    	
		    	Queue<TreeLinkNode> nq = new LinkedList<TreeLinkNode>();
		    	Queue<Integer> lq = new LinkedList<Integer>();
		    	nq.add(root);
		    	lq.add(0);
		    	while (nq.size() > 0)
		    	{
		    		TreeLinkNode node = nq.poll();
		    		int level = lq.poll();
		    		if (nq.size() == 0 || level < lq.peek())
		    		{
		    			node.next = null;
		    			if (node.left != null) 
		    			{
		    				nq.add(node.left);
		    				lq.add(level +1);
		    			}
		    			if (node.right != null)
		    			{
		    				nq.add(node.right);
		    				lq.add(level + 1);
		    			}
		    		}
		    	}
		    }
		} 