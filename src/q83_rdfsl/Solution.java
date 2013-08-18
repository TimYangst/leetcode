package q83_rdfsl;
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head ==  null)  return head;
        ListNode p = head;
        
        while (p!=null)
        {
        	ListNode q = p.next;
        	while (q!= null && q.val ==  p.val)
        	{
        		q = q.next;
        		p.next = q;
        	}
        	p = q;
        }
        return head;
    }
}