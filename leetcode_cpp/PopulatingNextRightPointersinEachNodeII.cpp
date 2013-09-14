#include <algorithm>
using namespace std;
struct TreeLinkNode {
   int val;
   TreeLinkNode *left, *right, *next;
   TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
  };
 
class Solution {
public:
    void connect(TreeLinkNode *root) {
        if (root == NULL) return;
		if (root ->left != NULL || root ->right != NULL){
			TreeLinkNode * next =  root->next;
			while (next != NULL){
				if (next ->left != NULL){
					next = next ->left;
					break;
				}
				if (next -> right != NULL){
					next = next->right;
					break;
				}
				next = next->next;
			} 	
			if (root->right != NULL) {
				root->right->next = next;
				connect(root->right);
			}
			if (root->left != NULL){
				root->left->next = (root->right != NULL? root->right:next);
				connect(root->left);
			}
		}
    }
};