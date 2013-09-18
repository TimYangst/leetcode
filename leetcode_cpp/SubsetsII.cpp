#include <vector>
#include <algorithm>
#include <map>
using namespace std;
class Solution {
	
public:
    vector<vector<int> > subsetsWithDup(vector<int> &S) {
		vector<vector<int>> rst;
		sort(S.begin(),S.end());
		map<int,int> count;
		for (int  i = 0; i <S.size(); i++)count[S[i]] ++;
		int j = 1;
		while (true) {
			vector<int> current;
			int k  = j;
			for (map<int,int>::iterator iter = count.begin(); iter != count.end() && k > 0; iter ++) {
				for (int u =  k % (iter->second + 1); u > 0 ; u--) current.push_back(iter->first);
				k /= (iter->second + 1);
			}
			rst.push_back(current);
			if (current.size() == 0) break;
			j ++;
		}
		return rst;
    }
};