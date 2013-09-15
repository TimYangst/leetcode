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
		if  (head == NULL) return head;
		while (head ->next != NULL && head ->next ->val == head ->val) head ->next = head->next->next;
		deleteDuplicates(head ->next);
		return head;
    }
};