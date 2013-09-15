#include <algorithm>
using namespace std;
struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };
 
class Solution {
public:
    ListNode *removeNthFromEnd(ListNode *head, int n) {
		if (head == NULL) return head;
		ListNode * first = head;
		ListNode * second = NULL;
		while (n >0 && first != NULL) { n --; first= first->next;}
		if (n !=0)return head;
		else {
			if (first == NULL) return head ->next;
			first = first->next;
			second =  head;
			while (first != NULL) {
				first = first ->next;second = second ->next;
			}
			second ->next = second->next->next;
		}
		return head;
    }
};