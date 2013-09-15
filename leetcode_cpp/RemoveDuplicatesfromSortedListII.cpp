#include <algorithm>
using namespace std;
struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };
 
class Solution {
public:
    ListNode *deleteDuplicates(ListNode *head) {
        if (head == NULL) return head;
		if (head ->next == NULL) return head;
		if  (head ->next->val == head ->val ){
			while (head->next!=NULL && head ->next->val == head->val) head = head ->next;
			return deleteDuplicates(head->next);
		}
		head->next = deleteDuplicates(head->next);
		return head;
    }
};