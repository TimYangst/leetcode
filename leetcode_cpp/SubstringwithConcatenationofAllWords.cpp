#include <vector>
#include <map>
using namespace std;
class Solution {
public:
    vector<int> findSubstring(string S, vector<string> &L) {
		vector<int> rst;
		if (S.length() ==0 || L.size() ==0) return rst;
		int N = L.size();
		int M = L[0].size();
		map<string,int> count;
		for (int i = 0; i < N; i++) count[L[i]] --;
		for (int i = 0; i < M; i++){
			map<string,int> current(count);
			int b = i;
			int tot = N;
			for (int j = i ; j + M  <= S.length() ; j += M){
				int k = current[S.substr(j,M)] ++;
				tot --;
				if (k < 0) {
					if (tot == 0){
						rst.push_back(b);
						current[S.substr(b,M)] --;
						b += M;
						tot ++;
					}
				}else {
					while (current[S.substr(j,M)] >0){
						tot ++;	
						current[S.substr(b,M)] --;
						b += M;
					}
					if (b + M * N > S.length()) break;
				}
			}
		}
		return rst;
    }
};
