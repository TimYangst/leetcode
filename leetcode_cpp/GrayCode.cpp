#include<vector>
using namespace std;
class Solution {
public:
    vector<int> grayCode(int n) {
		int num = 1<<n;
		vector<int> rst(num);
		for (int i = 0; i< num;i++){
			rst[i] = (i >> 1) ^ i;
		}
		return rst;
    }
};