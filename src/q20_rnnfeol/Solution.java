package q20_rnnfeol;

/**
 * Definition for singly-linked list.
 * */
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1,p2;
        if (n <=0 ) return head;
        
        int k = n;
        p1 = head; 
        while (k > 0 && p1 != null)
        {
        	k--;
        	p1 = p1.next;
        }
        if (k ==0 && p1 ==null)
        {
        	head = head.next;
        	return head;
        }
        if (p1 != null)
        {
        	p1 = p1.next;
        	p2 = head;
        	while (p1 != null)
        	{
        		p1= p1.next;
        		p2 =p2.next;
        	}
        	p2.next = p2.next.next;
        }
    	return head;
    }
}