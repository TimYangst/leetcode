#include <vector>
using namespace std;
struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };
 
class Solution {
	ListNode * merge(ListNode * l1, ListNode * l2){
		if (l1 == NULL) return l2;
		if (l2 == NULL) return l1;
		ListNode * head =NULL;
		if (l1->val < l2->val) {
			head = l1;
			head->next = merge(l1->next,l2);
		}else {
			head = l2;
			head->next = merge(l1,l2->next);
		}
		return head;
	}
public:
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        if (lists.size() == 0 ) return NULL;
		if (lists.size() == 1 ) return lists[0];
		vector<ListNode *> mid ;
		for (int i =0 ; i < lists.size(); i += 2){
			if (i + 1 == lists.size()) mid.push_back(lists[i]);
			else mid.push_back(merge(lists[i],lists[i+1]));
		}
		return mergeKLists(mid);
    }
};