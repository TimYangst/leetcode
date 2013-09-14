#include <algorithm>
using namespace std;
struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
  };
 
class Solution {
	void search(TreeNode * root, TreeNode * & pred, TreeNode * & first,TreeNode * & second){
		if (root == NULL) return ;
		if (root->left != NULL) {
			search(root->left,pred,first,second);
		}
		if (pred != NULL && pred->val > root->val) {
			second = root;
			if (first == NULL) first =  pred;
			
		}
		pred = root;
		if (root->right != NULL){
			search(root->right,pred,first,second);
		}
	}
public:
    void recoverTree(TreeNode *root) {
        if (root == NULL) return;
		TreeNode * first = NULL;
		TreeNode * second = NULL;
		TreeNode * pred = NULL;
		search(root,pred,first,second);
		int tmp = first->val;
		first->val = second ->val;
		second ->val =tmp;
    }
};