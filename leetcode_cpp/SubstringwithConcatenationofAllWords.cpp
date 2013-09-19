#include <vector>
#include <map>
using namespace std;
class Solution {
public:
    vector<int> findSubstring(string S, vector<string> &L) {
		vector<int> rst;
		if (S.length() ==0 || L.size() ==0) return rst;
		map<string,int> count;
		int tot;
		for (int  i = 0 ; i <  L.size(); i++ ) {
			if (count[L[i]] -- == 0) tot ++;
		}
		int len =  L[0].length();
		for  (int i = 0; i< len ; i ++){
			map<string,int> current(count); 
			int j = i;
			int k = j - len;
			int tmp = tot;
			while (j < S.length()){
				while (tot > 0){
					current[S.substr(
				}
			}
		}
        
    }
};