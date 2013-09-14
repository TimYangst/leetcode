#include <string>
#include <vector>
using namespace std;
class Solution {
public:
    string getPermutation(int n, int k) {
		vector<int> f(n+1);
		vector<int> num;
		f[0] = 1;
		for (int i = 1;i <= n; i++) f[i] = i * f[i-1];
		for (int i = 1; i <= n; i++) num.push_back(i);
		string rst = "";
		k--;
		for (int i = 0;i < n; i++){
			int j = k / f[n-i-1];
			vector<int>::iterator iter =  num.begin();
			for (int i = 0; i<j ; i++) iter++;
			rst += '0' + *iter;
			num.erase(iter);
			k = k % f[n-i-1];
		}
		return rst;
    }
};