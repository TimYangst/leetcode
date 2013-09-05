#include <algorithm>
using namespace std;

struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
  };
 
class Solution {
	bool  isBalanced(TreeNode * root, int & height){
		if (root == NULL) { height = 0; return true;};
		int rheight,lheight;
		if (isBalanced(root->left,lheight) && isBalanced(root->right,rheight)){
			if (abs(lheight - rheight) <2 ) { 
				height = max(lheight,rheight) + 1;
				return true;
			} 
		}
		return false;
	}

public:
    bool isBalanced(TreeNode *root) {
        int height;
		return isBalanced(root, height);
    }
};