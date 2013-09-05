#include <vector>
#include <queue>
using namespace std;
struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
  };
class Solution {
public:
    vector<vector<int> > levelOrder(TreeNode *root) {
		vector<vector<int>> rst;
		if (root == NULL) return rst;
		queue<TreeNode *> current;
		current.push(root);
		while (current.size() > 0 ) {
			vector<int> ele;
			queue<TreeNode*> nextlevel;
			while (current.size() > 0) {
				TreeNode * p = current.front();
				ele.push_back(p->val);
				current.pop();
				if (p->left != NULL) nextlevel.push(p->left);
				if (p->right != NULL) nextlevel.push(p->right);
			}
			rst.push_back(ele);
			current =  nextlevel;
		}
		return rst;
    }
};
