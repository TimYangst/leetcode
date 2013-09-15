#include <algorithm>
using namespace std;
struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };
 
class Solution {
	ListNode * toReverse(ListNode * head ,int n, ListNode * & tail){
		if (n == 1){
			tail = head;
			return head;
		}else {
			ListNode * current = toReverse(head ->next,n-1,tail);
			head->next = tail->next;
			tail->next = head;
			tail =  head;
			return current;
		}
	}
public:
    ListNode *reverseBetween(ListNode *head, int m, int n) {
        if (head == NULL) return head;
		if ( m > 1 ) head ->next = reverseBetween(head ->next,m-1,n-1);
		else {
			ListNode* tail = NULL;
			return toReverse(head,n,tail);
		}
    }
};