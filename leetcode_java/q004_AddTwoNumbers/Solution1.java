package q004_AddTwoNumbers;

public class Solution1 {

	private ListNode createNode(ListNode p1, ListNode p2, int floor){
		int tot = floor;
		if (p1 != null) tot += p1.val;
		if (p2 != null) tot += p2.val;
		return new ListNode(tot);
 	} 
	
	private int toFloor(ListNode p)
	{
		if (p.val >= 10){
			p.val -= 10;
			return 1;
		}
		return 0;
	}
	
	private ListNode getNext(ListNode p)
	{
		return (p == null)?null:p.next;
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		
		int floor = 0;
		if (l1 == null && l2 == null) return null;
		
		ListNode ans = createNode(l1, l2, floor);
		floor = toFloor(ans);
		
		ListNode last = ans;
		
		ListNode p1 = getNext(l1);
		ListNode p2 = getNext(l2);
		
		while (p1 != null || p2 != null){
			last.next = createNode(p1, p2, floor);
			floor = toFloor(last.next);
			last = last.next;
			p1 = getNext(p1);
			p2 = getNext(p2);
		}
		if (floor == 1)
		{
			last.next = new ListNode(1);
		}
		return ans;
	}

}
