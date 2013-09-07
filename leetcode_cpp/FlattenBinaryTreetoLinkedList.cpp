#include<algorithm>
using namespace std;
struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
  };
 
class Solution {
	TreeNode * search(TreeNode * root, TreeNode * last){
		if (root == NULL) return last;
		TreeNode * right =  root->right;
		TreeNode * left =  root->left;
		last->right = root;
		last->left = NULL;
		return search(right,search(left,root));
	}
public:
    void flatten(TreeNode *root) {
        if (root == NULL) return;
		TreeNode * right = root->right;
		TreeNode * left = root->left;
		search(right,search(left,root));
    }
};