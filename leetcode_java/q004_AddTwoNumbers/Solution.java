package q004_AddTwoNumbers;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int floor = 0;
        ListNode ans = new ListNode(l1.val + l2.val); 
        if (ans.val >= 10) {
            ans.val -= 10;
            floor = 1;
        }
        ListNode p1 = l1.next;
        ListNode p2 = l2.next;
        ListNode last = ans;
        while (p1 != null && p2 != null){
            last.next = new ListNode(p1.val + p2.val +floor);
            if (last.next.val >= 10){
                last.next.val -= 10;
                floor = 1;
            } else {
                floor = 0;
                
            }
            last = last.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null){
            last.next = new ListNode(p1.val + floor);
            if (last.next.val >= 10){
                last.next.val -= 10;
                floor = 1;
            } else {
                floor = 0;
            }
            last = last.next;
            p1 = p1.next;
        }
        while (p2 != null){
            last.next = new ListNode(p2.val + floor);
            if (last.next.val >= 10) {
                last.next.val -= 10;
                floor = 1;
            } else {
                floor = 0;
            }
            last = last.next;
            p2 = p2.next;
        }
        if (floor == 1){
            last.next = new ListNode(1);
        }
        return ans;
        
    }
}