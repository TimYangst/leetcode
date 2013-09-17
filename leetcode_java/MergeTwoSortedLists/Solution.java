package MergeTwoSortedLists;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode head, last, p1, p2;
		p1 = l1;
		p2 = l2;
		if (p1.val < p2.val) {
			head = p1;
			p1 = p1.next;
		} else {
			head = p2;
			p2 = p2.next;
		}
		last = head;
		while (p1 != null && p2 != null) {
			if (p1.val < p2.val) {
				last.next = p1;
				p1 = p1.next;
			} else {
				last.next = p2;
				p2 = p2.next;
			}
			last = last.next;
		}
		if (p1 != null) {
			last.next = p1;
		} else {
			last.next = p2;
		}
		return head;
	}
}