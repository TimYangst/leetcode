#include<vector>
using namespace std;
class Solution {
public:
    vector<string> generateParenthesis(int n) {
		vector<vector<string>> rst;
		vector<string> zero(1,"");
		vector<string> one(1,"()");
		rst.push_back(zero);
		rst.push_back(one);
		for (int i = 2;i<=n;i++){
			vector<string> current;
			for (int  j = 1; j <=i ;j++){
				for (int  u = 0; u<rst[j-1].size(); u++){
					for (int v= 0 ;v<rst[i-j].size(); v++){
						string ele("(");
						ele += rst[j-1][u];
						ele += ")";
						ele += rst[i-j][v];
						current.push_back(ele);
					}
				}
			}
			rst.push_back(current);
		}
		return rst[n];
    }
};