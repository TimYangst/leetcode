#include<iostream>
using namespace std;

struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };
 
class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
      if (l1 == NULL) return l2;
	  if (l2 == NULL) return l1;
	  return addTwoNumbers(0 , l1, l2);
    }

	ListNode * addTwoNumbers(int left, ListNode * l1, ListNode * l2){
		if (l1 == NULL && l2 == NULL) 
			return (left == 0) ? NULL : new ListNode(left);
		ListNode * rst = new ListNode(left);
		if (l1 != NULL) { rst ->val += l1->val; }
		if (l2 != NULL) { rst ->val += l2->val; }
		int nl = 0;
		if (rst -> val >= 10) { rst -> val -=10 ; nl ++; }
		rst->next = addTwoNumbers(nl,(l1 == NULL)?l1:l1->next,(l2==NULL)?l2:l2->next);
	}
};