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
	vector<vector<int> > zigzagLevelOrder(TreeNode *root) {
		vector<vector<int>> rst;
		if (root == NULL) return rst;
		bool oddtag = true;
		stack<TreeNode *>  current;
		current.push(root);
		while (!current.empty()){
			stack<TreeNode *> next;
			vector<int> ele;
			while (!current.empty()){
				TreeNode * top =  current.top();
				current.pop();
				ele.push_back(top->val);
				if (oddtag) {
					if (top->left != NULL) next.push(top->left);
					if (top->right!= NULL) next.push(top->right);
				}else {
					if (top->right!= NULL) next.push(top->right);
					if (top->left != NULL) next.push(top->left);
				}
			}
			rst.push_back(ele);
			current = next;
			oddtag =  !oddtag;
		}
		return rst;
	}
};