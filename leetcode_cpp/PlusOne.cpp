#include <vector>
using namespace std;
class Solution {
public:
    vector<int> plusOne(vector<int> &digits) {
		reverse(digits.begin(),digits.end());
		int i = 0;
		for (;i < digits.size(); i++){
			digits[i] ++;
			if (digits[i] == 10) {
				digits[i] =0;
			} else break;
		}
		if (i == digits.size()) digits.push_back(1);
		reverse(digits.begin(),digits.end());
		return digits;
    }
};