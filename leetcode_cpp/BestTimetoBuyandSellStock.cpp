#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int maxProfit(vector<int> &prices) {
		int rst=0;
		if (prices.size() <= 1) return rst;
		int lower = prices[0];
		for (int i = 1; i< prices.size(); i++){
			rst = max(prices[i] - lower,rst);
			lower =  min(prices[i], lower);
		}
		return rst;
    }
};