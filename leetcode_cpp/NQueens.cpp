#include <vector>
using namespace std;

class Solution {
	
	void search(int level,int vertical,int obliqueDown,int obliqueUp,int n,vector<string> & current, vector<vector<string>> & rst){
		for (int i = 0; i < n ;i++){
			if (((1<<i) & vertical )||((1<<(i + level)) & obliqueDown)||((1 << (i-level + n -1))& obliqueUp)){
				continue;
			} else {
				current[level][i] ='Q';
				if (level == n - 1){
					rst.push_back(current);
				}else {
					search(level+1,((1<<i) | vertical ),((1<<(i + level)) | obliqueDown),((1 << (i-level + n -1))| obliqueUp),n,current,rst);
				}
				current[level][i] = '.';
			}
		}
	} 
public:
    vector<vector<string> > solveNQueens(int n) {
		vector<vector<string>> rst;
		vector<string> ele;
		if (n <= 3 && n != 1) return rst;
		string mod = "";
		for (int i = 0;i < n; i++) mod += ".";
		for (int i = 0;i < n; i++) ele.push_back(mod);
		search(0,0,0,0,n,ele,rst);
		return rst;
    }
};