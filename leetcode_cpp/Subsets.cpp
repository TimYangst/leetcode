#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:
    vector<vector<int> > subsets(vector<int> &S) {
		vector<vector<int>> rst;
		sort(S.begin(),S.end());
		int j = 1;
		while (true){
			vector<int> current;
			for (int k = j, i = 0; i< S.size() && k > 0; i ++ ){
				if (k & 1) current.push_back(S[i]);
				k = k>>1;
			}
			rst.push_back(current);
			if (current.size() == 0) break;
		}
		return rst;
    }
};