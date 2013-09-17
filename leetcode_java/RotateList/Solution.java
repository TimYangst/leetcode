package RotateList;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
    	if (head == null) return head;
    	int length = 0;
    	ListNode  p =  head,q;
    	int  m = n;
    	while ( p !=  null)
    	{
    		p = p.next;
    		length ++;
    	}
    	m =  n % length;
    	if ( m ==  0) return head;
    	p = head;
    	while (m >0) { p = p.next; m --;}
    	q = head;
    	while (p .next != null)
    	{
    		q= q.next;
    		p= p.next;
    	}
    	p.next =  head;
    	head = q.next;
    	q.next = null;
    	return head;
    }
}