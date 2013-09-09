#include <vector>
using namespace std;

class Solution {
public:
    int maxProfit(vector<int> &prices) {
		int rst = 0;
		if (prices.size() <= 1 ) return rst;
		int lower =  prices[0];
		for (int i =1; i < prices.size(); i++ ) {
			if (prices[i] > lower) {
				rst += prices[i] - lower;
			}
			lower = prices[i];
		}
		return rst;        
    }
};