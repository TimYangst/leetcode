#include <vector>
using namespace std;
class Solution {
public:
    int maxSubArray(int A[], int n) {
		if(n == 0) return 0;
		int rst = A[0];
		for (int i = 1; i < n; i++){
			if (A[i-1] > 0) A[i]+=A[i-1];
			rst = max(rst,A[i]);
		}
		return rst;
    }
};