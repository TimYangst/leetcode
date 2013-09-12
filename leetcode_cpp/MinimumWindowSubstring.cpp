#include <string>
#include <vector>
using namespace std;
class Solution {
public:
    string minWindow(string S, string T) {
		if (T == "" || S=="") return "";
        vector<int> count(256,0);
		int total = 0;
		for (int i = 0; i< T.size(); i++ ) {
			count[T[i]] --;
			if (count[T[i]] == -1) total ++;
		}
		int minlength = S.length()+1;
		string rst ="";
		int i1=0,i2=-1;
		do {
			while (total >0 && i2 + 1 < S.length()){
				i2++;
				count[S[i2]] ++;
				if  (count[S[i2]] == 0) total --;
				while (i1 <= i2 && count[S[i1]] >0) {
					count[S[i1]] --;
					i1++;
				}
			}
			if (total==0) {
				if (i2 - i1 + 1 < minlength ) {
					minlength = i2 -i1 +1;
					rst = S.substr(i1,minlength);
				}
				count[S[i1++]]--;
				total ++;
			}else break;
		}while (true);
		return rst;
    }
};