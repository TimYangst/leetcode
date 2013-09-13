#include <vector>
using namespace std;
class Solution {
public:
    vector<vector<string>> partition(string s) {
		vector<vector<string>> tmp;
		if (s.length() == 0) return tmp;

		vector<vector<bool>> palind(s.length());
		for (int i = 0; i< s.length(); i++) {
			palind[i].push_back(true);
			palind[i].push_back(true);
		}
		for (int j = 1; j <s.length(); j++){
			for (int i =0; j + i <s.length(); i++){
				palind[i].push_back(s[i] == s[i+j] && palind[i+1][j-1]);
			}
		}
		vector<vector<vector<string>>> f;
		vector<string> ele;
		ele.push_back(s.substr(0,1));
		tmp.push_back(ele);
		f.push_back(tmp);
		for (int i = 1; i< s.length(); i++){
			vector<vector<string>> record;
			if  (palind[0][i]) {
				vector<string> ele;
				ele.push_back(s.substr(0,i+1));
				record.push_back(ele);
			}
			for  (int j = 1; j <= i; j++ ){
				if (palind[j][i-j+1]){
					for (int k = 0 ;k <f[j-1].size(); k++) {
						vector<string> ele= f[j-1][k];
						ele.push_back(s.substr(j,i-j+1));
						record.push_back(ele);
					}
				}
			}
			f.push_back(record);
		}
		return f[s.length()-1];
    }
};