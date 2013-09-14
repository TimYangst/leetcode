#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:
    vector<vector<int> > permute(vector<int> &num) {
		vector<vector<int>> rst;
		if (num.size() == 0) return rst;
		sort(num.begin(),num.end());
		rst.push_back(num);
		while (true){
			int j = -1;
			for (int i = 0 ;i < num.size()-1; i ++){
				if (num[i]<num[i+1]) j = i;
			}
			if (j == -1) break;
			int k = j + 1;
			for (int i = k; i<num.size();i++){
				if (num[i] > num[j] && num[i] <= num[k]) k = i;
			}
			swap(num[j], num[k]);
			for (int i = j+1; i<= (j + num.size())/2; i++){
				swap(num[i], num[num.size()- (i-j)]);
			}
			rst.push_back(num);
		}
		return rst;
    }
};