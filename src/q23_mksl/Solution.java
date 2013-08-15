package q23_mksl;

/**
 * Definition for singly-linked list.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}



class ListNodeComparer implements Comparator<ListNode> {
	@Override
	public int compare(ListNode o1, ListNode o2) {
		return o1.val - o2.val;
	}
}

public class Solution {

	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		ListNode rst = null;
		if (lists.size() == 0)
			return null;
		else if (lists.size() == 1)
			return lists.get(0);
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(
				lists.size(), new ListNodeComparer());
		for (ListNode node : lists)
		{
			if (node != null )
			{
				queue.offer(node);
			}
		}
		if (queue.size() > 0)
		{
			ListNode p = queue.poll();
			if (p.next != null) queue.offer(p.next);
			rst =  p;
			
			while (queue.size() > 0)
			{
				ListNode q = queue.poll();
				if (q.next != null) queue.offer(q.next);
				p.next = q;
				p = q;
			}
			
			return rst;
		}
		return null;
	}
}