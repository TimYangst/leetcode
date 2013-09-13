#include <algorithm>
using namespace std;
struct TreeNode
{
	TreeNode * left, *right;
	int val;
};

bool isBstTree(TreeNode * root, int & size, TreeNode * & first, TreeNode * & last, int & maxsize, TreeNode * & rst){
	if (root ==  NULL) {
		size = 0;
		first = last = NULL;
		return true;
	}
	if (root->left == NULL && root -> right == NULL){
		size = 1 ;
		first = last = root;
		if (size > maxsize) {
			maxsize = size;
			rst = root;
			return true;
		}
	}
	TreeNode * lfirst = NULL;
	TreeNode * llast = NULL;
	int lcount = 0;
	bool  lbst = true;
	size = 1;
	if (isBstTree(root->left, lcount, lfirst,llast, maxsize, rst )){
		if (lcount == 0) {
			first = root;
		}else if (root->val >= llast->val){
			size += lcount;
			first = lfirst;
		} else  lbst = false;
	} else lbst = false;
	TreeNode * rfirst = NULL;
	TreeNode * rlast = NULL;
	int rcount = 0;
	bool rbst =  true;
	if (isBstTree(root->right, rcount, rfirst,rlast, maxsize, rst)) {
		if (rcount == 0){
			last = root;
		} else if (root->val <= rfirst->val){
			size += rcount;
			last = rlast;
		} else rbst = false;
	} else rbst =  false;
	if (!(lbst && rbst)) return false;
	if (size > maxsize) {
		maxsize = size;
		rst = root;
	}
	return true;
};

TreeNode * maxBstTree(TreeNode * root)
{
	if (root == NULL) return root;
	if (root->left == NULL && root -> right == NULL) return root;
	int maxsize = 0;
	TreeNode * rst = NULL;
	TreeNode * first = NULL;
	TreeNode * last = NULL;
	int size = 0;
	isBstTree(root, size , first,last, maxsize, rst);
	return rst;
}