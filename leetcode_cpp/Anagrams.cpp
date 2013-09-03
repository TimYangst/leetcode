#include <vector>
#include <map>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<string> anagrams(vector<string> &strs) {
		vector<string> rst;
		if (strs.size() == 0) return rst;
		map<string,vector<string>> dict;
		for (int i = 0 ; i < strs.size(); i++){
			string index(strs[i]);
			sort(index.begin(),index.end());
			dict[index].push_back(strs[i]);
		}
		map<string,vector<string>>::iterator iter;
		for (iter = dict.begin();iter !=dict.end(); iter ++ ){
			vector<string> ele = iter->second;
			if (ele.size()>1) {
				for (vector<string>::iterator siter= ele.begin();siter != ele.end(); siter++){
					rst.push_back(*siter);	
				} 
			}
		}
		return rst;
    }
};