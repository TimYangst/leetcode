#include<vector>
using namespace std;

class Solution {
public:
    int maxProfit(vector<int> &prices) {
		if (prices.size() <= 1) return  0;
		vector<int> onetime;
		onetime.push_back(0);
		int lower = INT_MAX;
		for (int i = 1 ; i< prices.size(); i++){
			onetime.push_back(max(onetime[i-1],prices[i] - lower));
			if (prices[i] <lower) lower  = prices[i];
		}
		int rst = onetime[prices.size()-1];
		int upper = prices[prices.size() -1];
		for (int  i = prices.size - 2; i >=0 ; i -- ){
			rst = max(rst, upper- prices[i] + onetime[i]);	
			if (prices[i] > upper) upper = prices[i];
		}
		return rst;
    }
};