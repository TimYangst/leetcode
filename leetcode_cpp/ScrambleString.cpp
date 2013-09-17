#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    bool isScramble(string s1, string s2) {
		if (s1 == s2) return true;
		if (s1.length() != s2.length()) return false;
		int len =  s1.length();
		if (len <= 1) return false;
		string a1(s1),a2(s2);
		sort(a1.begin(),a1.end()); sort(a2.begin(),a2.end());
		if (a1 != a2) return false;
		for (int i = 1; i< len; i++){
			if (isScramble(s1.substr(0,i),s2.substr(0,i))&& isScramble(s1.substr(i,len -i), s2.substr(i,len-i))) return true;
			if (isScramble(s1.substr(0,i),s2.substr(len-i,i)) && isScramble(s1.substr(i,len-i),s2.substr(0,len-i))) return true;
		}
		return false;
    }
};