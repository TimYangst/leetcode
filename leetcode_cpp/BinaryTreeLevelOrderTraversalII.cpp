#include <vector>
using namespace std;
struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
  };
 
class Solution {
	void levelOrderBottom(TreeNode * root,int level, vector<vector<int>>&rst){
		if (root == NULL) return;
		vector<int> ele;
		if (rst.size() == level) rst.push_back(ele);
		rst[level].push_back(root->val);
		levelOrderBottom(root->left,level+1,rst);
		levelOrderBottom(root->right,level+1,rst);
	}
public:
    vector<vector<int> > levelOrderBottom(TreeNode *root) {
		vector<vector<int>> rst;
		levelOrderBottom(root,0,rst);
		reverse(rst.begin(),rst.end());
		return rst;
    }
};