#include <string>
#include <vector>
using namespace std;
class Solution {
public:
    int minCut(string s) {
		if (s.length() <= 1) return 0;
		vector<vector<bool>> isPalind(s.length());
		for  (int i =0 ;i <s.length(); i++) {
			isPalind[i].push_back(true);
			isPalind[i].push_back(true);
		}
		for  (int j = 1; j <s.length(); j++){
			for  (int i = 0; i+j<s.length(); i++){
				isPalind[i].push_back(s[i] == s[i+j] && isPalind[i+1][j+1-2]);
			}
		}
		vector<int> f(s.length());
		f[0] = 0;
		for (int i =1 ;i <s.length(); i++){
			if  (isPalind[0][i+1]) f[i] = 0;
			else {
				f[i] = f[i-1]+1;
				for  (int j = 1; j <= i;j++){
					if (isPalind[j][i-j+1] && f[j-1] + 1 < f[i])
						f[i] = f[j-1]+1;
				}
			}
		}
		return f[s.length() -1];
    }
};