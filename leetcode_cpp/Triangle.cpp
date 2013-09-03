#include<vector>
using namespace std;

class Solution {
public:
    int minimumTotal(vector<vector<int> > &triangle) {
		if (triangle.size() == 0) return 0;
		if (triangle.size() == 1) return triangle[0][0];
		vector<int> current =  triangle[0];
		for (int  i = 1; i < triangle.size(); i++) {
			vector<int> before = current;
			current = triangle[i];
			current[0] += before[0];
			current[i] += before[i-1];
			for (int j =  1; j< i; j++) 
				current[j] += min(before[j-1],before[j]);
		}
		int rst =  current[0];
		for  (int i = 1 ;i < current.size(); i++ ) rst = min(rst,current[i]);
		return rst;
    }
};