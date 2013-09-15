#include<algorithm>
using namespace std;
struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };
 
class Solution {
public:
    ListNode *reverseKGroup(ListNode *head, int k) {
		if (head == NULL || k <=1) return head;
		int j = k;
		ListNode * p =  head;
		while (  p != NULL  && j > 0   ) {
			j-- ;
			p=p->next;
		}
		if (j > 0) return head;
		ListNode * rst = reverseKGroup(p,k);
		p = head;
		for (int i = 0 ;i < k ;i++ ){
			ListNode * q = p ->next;
			p->next =  rst;
			rst = p;
			p = q;
		}
        return rst;
    }
};