#include <vector>
using namespace std;
class Solution {
	int gcd(int a,int b){
		if (a < b) return gcd(b,a);
		if (a % b == 0) return b;
		return gcd(b, a % b);
	}
public:
    vector<int> getRow(int rowIndex) {
		vector<int> rst;
		if (rowIndex == 0) {rst.push_back(1); return rst;}
		if (rowIndex == 1) {rst.push_back(1);rst.push_back(1); return rst;};
		int k = 1;
		rst.push_back(k);
		for (int i = 1; i <= rowIndex; i++ ){
			int m =  rowIndex-i+1;
			int g =  gcd(m,i);
			k = (k / (i / g)) * ( m / g);
			rst.push_back(k);	
		}
		return rst;
    }
};