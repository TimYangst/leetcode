#include<vector>
using namespace std;
class Solution {
	void search(int l ,int r, string s, vector<string> & rst){
		if (l == 0 && r == 0)  rst.push_back(s);
		if (l > 0){ string t(s); t+= "("; search(l-1,r,t,rst);}
		if (r > l){ string t(s); t+= ")"; search(l,r-1,t,rst);}
	}

public:
    vector<string> generateParenthesis(int n) {
		vector<string> rst ;
		search(n,n,"",rst);
		return rst;
    }
};