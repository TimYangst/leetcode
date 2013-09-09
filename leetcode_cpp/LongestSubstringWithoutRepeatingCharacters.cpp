#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
		vector<int> index(26,-1);
		int i,rst = 0;

		int upper= -1;
		for (int  i = 0; i< s.length();i++){
			if (index[s[i] -'a'] > upper) upper =  index[s[i]-'a'];
			rst = max(rst,i-upper);
			index[s[i] -'a'] = i;
		}
		return rst;
    }
};