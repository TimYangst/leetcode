#include <vector>
using namespace std;;
class Solution {
	bool isInRange(string str){
		if (str.length() > 1 && str[0] == '0') return false;
		int k = 0;
		for  (int i= 0; i<str.length(); i++){
			if ('0' > str[i] || '9' < str[i]) return false;
			k = k * 10 + str[i] -'0';
		}
		return 0 <= k && k <= 255;
	}

	void search(string str, int index,int num,string current, vector<string> & rst){
		if (index + (4 - num) * 1 >  str.length()  || index + (4 - num) * 3  < str.length()  ) return;
		if  (str[index] < '0' ||str[index] > '9' ) return ;
		if (num == 3) {
			string ele = str.substr(index, str.length() - index);
			if (isInRange(ele)){ current += ele; rst.push_back(current);}
			return ;
		}else {
			for  (int i = 1; i <= 3 ;i++){
				if (i + index >= str.length())break;
				string ele = str.substr(index,i);
				if (isInRange(ele)){
					string tmp = current; 
					tmp += ele ;
					tmp +='.';
					search(str,i+index,num +1,tmp,rst);
				}
			}
		}
	}
public:
    vector<string> restoreIpAddresses(string s) {
		vector<string> rst;
        search(s,0,0,"",rst);
		return rst;
    }
};
//int main(){
//	Solution s;
//	s.restoreIpAddresses("0000");
//}