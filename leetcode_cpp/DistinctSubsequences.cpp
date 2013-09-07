#include<string>
#include<hash_map>
using namespace std;
class Solution {
public:
    int numDistinct(string S, string T) {
		vector<vector<int>> res(S.length()+1);
	
		res[0].push_back(1);

		for (int i = 1 ; i<=S.length();i++) res[i].push_back(1);
		for (int j = 1 ; j<=T.length();j++) res[0].push_back(0);
		for(int i = 1; i <=S.length();i++){
			for (int j = 1; j<=T.length(); j++){
				res[i].push_back(res[i-1][j]);
				if (S[i-1] == T[j-1]) res[i][j] += res[i-1][j-1];
			}
		}
		return res[S.length()][T.length()];
    }
};