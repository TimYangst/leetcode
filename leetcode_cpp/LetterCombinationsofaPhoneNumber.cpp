#include <vector>
#include <stack>
using namespace std;
class Solution {
	void search(int level, string & digits, string str, vector<string> & rst,string * map){
		if (level ==  digits.size()){
			rst.push_back(str);
			return ;
		}
		if ('0' <= digits[level] && digits[level] <= '9'){
			for (int i = 0 ;i < map[digits[level]-'0'].size();i++){
				string t(str);
				t+= map[digits[level]-'0'][i];
				search(level+1,digits,t,rst,map);
			}
		} 
	}
	
public:
    vector<string> letterCombinations(string digits) {
		string map[] = { "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz" };
		vector<string> rst;
		search(0, digits,"",rst,map);
		return rst;
    }
};