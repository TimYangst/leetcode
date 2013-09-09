package q82_RemoveDuplicatesfromSortedListII;


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
      if (head.next == null) return head;
      if (head.val ==  head.next.val)
      {
    	  int val = head.val;
    	 while (head != null && head.val == val) head = head.next;
    	 return deleteDuplicates(head);
      }
      head.next = deleteDuplicates(head.next);
      return head;
  }
}