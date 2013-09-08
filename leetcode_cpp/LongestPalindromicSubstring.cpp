#include<string>
#include<vector>
using namespace std;
class Solution {
public:
    string longestPalindrome(string s) {
		if (s.length() <= 1) return s;
		bool f[1001][1001];
		int rst_i=0,rst_l=0;
		for (int i = 0 ;i <s.length(); i++) {f[i][0] = true;f[i][1]=true;};
		for (int j = 2 ; j<=s.length(); j ++){
			for (int i =0 ;i <= s.length() - j;i++){
				f[i][j] = f[i+1][j-2] && s[i] == s[i+j-1];
				if (f[i][j]) {
					rst_i = i;rst_l = j;
				}
			}
		}
		return s.substr(rst_i,rst_l);
    }
};