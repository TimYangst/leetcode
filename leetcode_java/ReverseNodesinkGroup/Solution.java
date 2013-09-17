package ReverseNodesinkGroup;

import java.util.Stack;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 1)
			return head;

		ListNode rst = null;
		ListNode p = head;

		Stack<ListNode> stack = new Stack<ListNode>();

		int j = k;

		while (j > 0 && p != null) {
			stack.push(p);
			p = p.next;
			j--;
		}
		ListNode tail = null;
		if (j > 0)
			return head;

		tail = reverseKGroup(p, k);

		rst = stack.pop();
		p = rst;
		while (stack.size() > 0) {
			p.next = stack.pop();
			p = p.next;
		}
		p.next = tail;
		return rst;
	}
}