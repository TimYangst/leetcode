#include<vector>
using namespace std;
struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
  };

 class Solution {
	 void search(TreeNode * root, vector<int>& ele,int sum, vector<vector<int>> & rst){
		 if (root == NULL) return ;
		 ele.push_back(root->val);
		 if  (root -> left == NULL && root -> right == NULL){
			 if (sum == root->val){
				 rst.push_back(ele);
			 }
			
		 } else {
			 if (root->left != NULL) search(root->left,ele,sum - root->val,rst);
			 if (root->right != NULL) search(root->right,ele,sum - root->val,rst);
		 }
		 ele.pop_back();
		 return;
	 }
public:
    vector<vector<int> > pathSum(TreeNode *root, int sum) {
		vector<vector<int>> rst;
		if  (root == NULL) return rst;
		vector<int> ele;
		search(root,ele,sum,rst);
		return rst;
    }
};