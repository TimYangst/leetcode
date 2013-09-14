#include<algorithm>
using namespace std;

struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };
 
class Solution {
public:
    ListNode *partition(ListNode *head, int x) {
		ListNode * shead = NULL, * stail = NULL;
		ListNode * bhead = NULL, * btail = NULL;
		ListNode * p = head, * q;
		while (p!=NULL){
			q = p->next;
			p->next = NULL;
			if (p->val <x ){
				if (shead == NULL) {
					shead = stail = p;
				}else {
					stail ->next = p;
					stail = p;
				}
			}else {
				if (bhead == NULL) {
					bhead =  btail = p;
				}else {
					btail ->next = p;
					btail = p;
				}
			}
			p = q;
		}
		if (shead == NULL) return bhead;
		stail ->next =bhead;
		return shead;
    }
};