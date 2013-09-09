#include <string>
#include <vector>
using namespace std;
class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
		if (s3.length() != s1.length()+ s2.length()) return false;
		vector<vector<bool>> f(s1.length()+1);
		f[0].push_back(true);
		for (int i =1; i<=s1.length(); i++){
			f[i].push_back(f[i-1][0] && s1[i-1] == s3[i-1]);
		} 
		for (int  j = 1; j<=s2.length(); j++){
			f[0].push_back(f[0][j-1] && s2[j-1] == s3[j-1]);
		}
		for (int i = 1; i <= s1.length(); i ++)
			for (int  j = 1; j<= s2.length(); j++){
				f[i].push_back(s1[i-1] == s3[i+j-1] && f[i-1][j] || s2[j-1] == s3[i+j-1] && f[i][j-1]);
			}
		return f[s1.length()][s2.length()];
    }
};