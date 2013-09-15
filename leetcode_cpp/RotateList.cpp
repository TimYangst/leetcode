#include <algorithm>
using namespace std;
struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };
 
class Solution {
public:
    ListNode *rotateRight(ListNode *head, int k) {
        if ( head == NULL || k ==  0) return head;
		int len = 0;
		ListNode * p  = head ,*tail = head;
		while ( p != NULL){ tail = p; p = p->next; len ++;}
		k = k % len;
		if ( k == 0) return head;
		p = head;
		
		while (k >= 0 ) { p = p->next; k--;}
		ListNode * q =  head;
		while (p != NULL){
			p = p->next;
			q= q->next;
		}
		p = q->next;
		tail->next =head;
		q->next = NULL;
		return p;
    }
};