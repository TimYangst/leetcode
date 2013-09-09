#include <vector>
#include <set>
using namespace std;
class Solution {
public:
    int longestConsecutive(vector<int> &num) {
        set<int> dict;
		for (int i = 0 ;i <num.size(); i++) {
			dict.insert(num[i]);
		}
		int rst = 0;
		for (int i = 0; i<num.size(); i++){
			if (dict.find(num[i])!=dict.end()){
				int k =  num[i];
				dict.erase(num[i]);
				int j = k-1;
				while (dict.find(j) != dict.end())dict.erase(j--);
				int u =  k+1;
				while (dict.find(u) != dict.end())dict.erase(u++);
				rst =  max(rst, u - j -1);
			}
		}
		return rst;
    }
};