#include <string>
#include <vector>
using namespace std;
class Solution {
	string commonprefix(string  a,string  b){
		int i = 0;
		while (i < min(a.length(),b.length())){
			if (a[i]!= b[i]) break;
			i++;
		}
		return a.substr(0 , i);
	}
	string binaryfind(int b,int e,vector<string> & strs){
		if (b == e) return strs[b];
		int mid = (b+e)>>1;
		return commonprefix(binaryfind(b,mid,strs) ,binaryfind(mid+1,e,strs));
	}
public:
    string longestCommonPrefix(vector<string> &strs) {
		if (strs.size() == 0) return "";
		return binaryfind(0,strs.size()-1,strs);
    }
};