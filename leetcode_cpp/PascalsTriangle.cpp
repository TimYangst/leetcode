#include<vector>
using namespace std;
class Solution {
public:
    vector<vector<int> > generate(int numRows) {
		vector<vector<int>> rst;
		if (numRows == 0) return rst;
		vector<int> first;
		first.push_back(1);
		rst.push_back(first);
		for (int  i = 1; i < numRows; i++){
			vector<int> ele(i+1);
			ele[0] = 1;ele[i] = 1;
			for (int j = 1; j < i; j++) ele[j] = rst[i-1][j-1]+ rst[i-1][j];
			rst.push_back(ele);
		}
		return rst;
    }
};