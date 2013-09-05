package q_2_1;

class ListNode {
	int val;
	ListNode next;
}

public class Q2_1_RemoveDuplicates {
	
	public ListNode removeDuplicatesFromLinkedList(ListNode head){
		if (head == null) return head;
		ListNode p = head;
		while (p.next != null) {
			if (p.next.val == head .val) p.next = p.next.next;
			else p = p.next;
		}
		removeDuplicatesFromLinkedList(head.next);
		return head;
	}
	

}
