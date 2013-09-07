#include <vector>
using namespace std;
struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
  };
 
class Solution {
	int searchMaxPath(TreeNode * root , int & onepath){
		if (root == NULL ) { onepath = INT_MIN; return INT_MIN;};
		int leftonepath,rightonepath;
		int leftpath =  searchMaxPath(root->left,leftonepath);
		int rightpath =  searchMaxPath(root->right,rightonepath);
		int rst =  root->val;
		onepath  =  root-> val;
		if (leftonepath > 0)  {
			rst += leftonepath;
			onepath = root->val + leftonepath;
		} 
		if (rightonepath > 0 ) {
			rst += rightonepath;
			onepath = max(onepath,root->val +rightonepath);
		}		
		rst = max(max(rst,max(leftpath, rightpath)),max(leftonepath,rightonepath));
	}
public:
    int maxPathSum(TreeNode *root) {
        if (root == NULL) return 0;
		int onepath;
		return searchMaxPath(root, onepath);
    }
};