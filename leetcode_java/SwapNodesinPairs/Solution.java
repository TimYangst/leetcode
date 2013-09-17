package SwapNodesinPairs;

/**
  Definition for singly-linked list.*/
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

public class Solution {
    public ListNode swapPairs(ListNode head) {
    	if (head == null) return head;
    	ListNode p,q,r;
    	
    	p = head;
    	q = head.next;
    	
    	if (q == null) return head;
    	
    	head = q;
    	p.next = q.next;
    	q.next = p;
    	
    	r = p;
    	p = p.next;
    	
    	
    	while (p!= null)
    	{
    		q = p.next;
    		if (q == null) break;
    		r.next = q;
    		p.next = q.next;
    		q.next= p;
    		r = p;
    		p = p.next;
    	}
    	
    	return head;
        
    }
}