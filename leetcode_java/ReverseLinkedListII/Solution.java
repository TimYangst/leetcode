package ReverseLinkedListII;
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

 
public class Solution {
	private  ListNode reverse(ListNode p,ListNode tail,int length)
	{
		if (length == 1) 
		{
			p.next = tail;
			return p;
		}else {
			ListNode q = p.next;
			p.next = tail;
			return reverse(q,p,length -1);
		}
		
	}
   public ListNode reverseBetween(ListNode head, int m, int n) {
	   
	   if (head == null) return head;
	   int length = n - m +1;
	   if (length == 1) return head;
	   ListNode tail = head;
	   for (int i = 0;i<n ;i++) tail = tail.next; 
	   if (m == 1)
	   {
		   return reverse(head,tail, length);
	   }
	   ListNode p = head;
	   ListNode q = null;
	   for (int i = 1;i< m ;i++)
	   {
		   q = p;
		   p=p.next;
	   }
	   q.next = reverse(p,tail,length);
       return head;
   }
}