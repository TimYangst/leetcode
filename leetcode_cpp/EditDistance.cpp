#include <string>
#include <vector>
using namespace std;
class Solution {
public:
    int minDistance(string word1, string word2) {
		vector<vector<int>> rst(word1.length()+1);
		rst[0].push_back(0);
		for (int i = 1; i<=word1.length();i++) rst[i].push_back(i);
		for (int j = 1; j<=word2.length();j++) rst[0].push_back(j);
		for (int i = 1; i<=word1.length();i++)
			for (int j= 1; j<=word2.length(); j++) {
				if (word1[i-1]==word2[j-1]) rst[i].push_back(rst[i-1][j-1]);
				else rst[i].push_back(min(rst[i-1][j-1],min(rst[i-1][j],rst[i][j-1]))+1);
			}
		return rst[word1.length()][word2.length()];
    }
};