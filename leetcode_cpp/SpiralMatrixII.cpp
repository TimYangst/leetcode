#include <vector>
using namespace std;
class Solution {
public:
    vector<vector<int> > generateMatrix(int n) {
		vector<int> ele(n,0);
		vector<vector<int>> rst(n,ele);
		if (n == 0) return rst;
		int k = 1;
		int b = 0, e = n -1;
		while (b < e){
			for (int j = b ; j< e ;j++) rst[b][j] = k++;
			for (int i = b ; i< e; i++) rst[i][e] = k++;
			for (int j = e ; j> b; j--) rst[e][j] = k++;
			for (int i = e ; i> b; i--) rst[i][b] = k++;
			b ++;
			e --;
		}
		if (b == e) rst[b][b] = k++;
		return rst;
    }
};