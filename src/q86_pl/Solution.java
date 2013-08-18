package q86_pl;
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

public class Solution {
   public ListNode partition(ListNode head, int x) {
	   if (head == null) return head;
	   if (head.val < x) {
		   head.next =  partition(head.next, x);
		   return head;
	   }
	   ListNode p = head.next, q = head;;
	   while (p!=null && p.val >= x) {
		   q = q.next;
		   p =p.next;
	   }
	   if (p == null) return head;
	   
	   q.next = p.next;
	   p.next = partition(head,x);
	   return p;
   }
}