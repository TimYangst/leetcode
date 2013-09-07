#include <string>
using namespace std;
class Solution {
	bool isDigit(char c){
		return  '0'<= c && c <= '9';
	}
	bool isdecodeable(char c1,char c2){
		if (c1 == '1' || c1 == '2' && '0' <= c2 && c2 <= '6') return true;
		return false;
	}

public:
    int numDecodings(string s) {
		if (s.length() == 0) return 0;
		if (s[0] == '0' || !isdigit(s[0])) return 0;
		int a0 = 1,a1 =1;
		for (int i = 1; i<s.length();i++){
			if (!isdigit(s[i])) return 0;
			int a2 = 0;
			if (s[i] != '0') a2 = a1;
			if (isdecodeable(s[i-1],s[i])){
				a2 += a0;
			}
			a0 = a1;
			a1 = a2;
		}
		return a1;
    }
};