#include<string>
#include<algorithm>
using namespace std;
class Solution {
public:
    string addBinary(string a, string b) {
		string rst;
		int left = 0, i =0;
		for ( i = 0; i < min(a.length(),b.length());i++){
			int sum = left + a[a.length() - i -1] - '0' + b[b.length()-i-1] - '0';
			if (sum  > 1) { sum -= 2; left = 1;}
			else left = 0;
			rst.push_back('0' + sum);
		}
		for (; i <a.length(); i++) {
			int sum = left + a[a.length()-i-1] -'0';
			if (sum > 1) {sum -= 2; left =1;}
			else left = 0;
			rst.push_back('0' + sum);
		}
		for (; i <b.length(); i++) {
			int sum = left + b[b.length()-i-1] -'0';
			if (sum > 1) {sum -= 2; left =1;}
			else left = 0;
			rst.push_back('0' + sum);
		}
		if (left > 0) rst.push_back('0' + left);
		reverse(rst.begin(),rst.end());
		return rst;
    }
};