#include <vector>
#include <stack>
using namespace std;
struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
  };
 
class Solution {
public:
    vector<int> inorderTraversal(TreeNode *root) {
		vector<int> rst;
		if (root ==  NULL) return rst;
		stack<TreeNode *> vstack;
		TreeNode * p =  root;
		while (p != NULL) {
			vstack.push(p);
			p = p->left;
		}
		while (!vstack.empty()){
			TreeNode * top = vstack.top();
			vstack.pop();
			rst.push_back(top->val);
			p = top->right;
			while (p != NULL){
				vstack.push(p);
				p = p->left;
			}
		}
		return rst;
    }
};