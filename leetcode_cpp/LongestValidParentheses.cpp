#include <string>
#include <stack>
using namespace std;
class Solution {
public:
    int longestValidParentheses(string s) {
		stack<int>  locstack;
		int rst= 0;
		int base= -1;
		for (int i = 0 ;i < s.length();i++){
			if (s[i] == ')') {
				if (locstack.size() >0 ){ 
					locstack.pop();
					rst=max(rst,(locstack.empty()?i-base:i-locstack.top()));
				}else base = i;
			}else{
				locstack.push(i);
			}
		}
		return rst;
    }
};