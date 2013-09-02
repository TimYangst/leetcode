#include<vector>
#include<algorithm>
using namespace std;

class Solution {
public:
    int threeSumClosest(vector<int> &num, int target) {
		sort(num.begin(), num.end());
		int min_dist = INT_MAX;
		int rst = 0;
		for (int i = 0 ; i < num.size() - 2; i++){
			int j = i + 1 ;
			int k =  num.size() - 1 ;
			while (k > j)
			{
				while (k > j + 1 && num[i] + num[j] + num[k -1] > target ) k --;
				if (abs(num[i] + num[j] + num[k]- target) < min_dist ) 	{
					min_dist = abs(num[i] + num[j] + num[k]- target);
					rst = num[i] + num[j] + num[k];
				}
				if (k > j + 1) {
					if (abs(num[i] + num[j] + num[k-1]- target) <  min_dist){
						min_dist = abs(num[i] + num[j] + num[k-1]- target);
						rst = num[i] + num[j] + num[k-1];
					}
				}
				if (min_dist == 0) break;
				j++;
			}
		}
		return rst;
    }
};