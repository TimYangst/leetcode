#include<vector>
#include<algorithm>
using namespace std;

class Solution {
public:
    vector<vector<int> > fourSum(vector<int> &num, int target) {
		vector<vector<int>> rst ;
		int n =  num.size();
		if (n < 4) return rst;
		vector<int> ele(4);
		sort(num.begin(),num.end());
		for (int i = 0 ; i <  n - 3; i++ ){
			for (int  j = i + 1 ; j < n - 2 ; j ++) {
				int sum = num[i] + num[j];
				ele[0] = num[i];
				ele[1] = num[j];
				int  k = j + 1;
				int  u = n - 1;
				while  (k < u){
					if (sum + num[k] + num[u] > target) u --;
					else if (sum + num[k]+num[u] < target) k++;
					else {
						ele[2] = num[k];
						ele[3] = num[u];
						rst.push_back(ele);
						while (k+1 <u && num[k+1] == num[k]) k++;
						k++; u--;
					}
				}
				 while (j < n - 2 && num[j+1] == num[j] ) j++;
			}
			while (i < n - 3 && num[i+1] == num[i]) i++;
		}
		return rst;
    }
};