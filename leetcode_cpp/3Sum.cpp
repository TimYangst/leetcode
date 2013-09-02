#include<vector>
#include<algorithm>
using namespace std;

class Solution {
public:
    vector<vector<int> > threeSum(vector<int> &num) {
		vector<vector<int>> rst;
		if (num.size() == 0) return rst;
		sort(num.begin(),num.end());
		vector<int> ele(3);
		for (int i = 0 ; i <(int)num.size() - 2; i++){
			int j = i + 1;
			int k = num.size() - 1;
			while (j < k){
				if (num[i] +num[j] + num[k] > 0) k --;
				else if (num[i] + num[j] + num[k] < 0) j++;
				else {
					ele[0] = num[i]; ele[1] = num[j]; ele[2] = num[k];
					rst.push_back(ele);
					while (j < k - 1 && num[j+1] == num[j]) j++;
					j ++;
					k --;
				}
			}
			while (i < num.size() - 1 && num[i+1] == num[i]) i++;
		}
		return rst;
    }
};