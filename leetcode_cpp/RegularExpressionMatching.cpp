#include<string>
using namespace std;

class Solution {
public:
    bool isMatch(const char *s, const char *p) {
		if (*p == '\0') return *s =='\0';
		if (*(p+1) == '*'){
			while (*s != '\0' && (*p == *s || *p =='.')) {
				if (isMatch(s,p+2))return true;
				s++;
			}
			return isMatch(s,p+2);
		}else {
			if (*s == '\0') return false;
			if (*p == '.' || *p == *s) return isMatch(s+1,p+1);
		}
		return false;
    }
};