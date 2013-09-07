#include <algorithm>
using namespace std;
class Solution {
public:
    bool canJump(int A[], int n) {
		int j =0;
		int i =-1;
		while (i < j ){
			i++;
			j = max(j, i+A[i]);
			if (j >= n-1) return true;
		}
		return false;
    }
};