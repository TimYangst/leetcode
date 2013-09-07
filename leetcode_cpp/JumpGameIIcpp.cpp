#include <vector>
using namespace std;
class Solution {
public:
    int jump(int A[], int n) {
		vector<int> step(n,-1);
		step[0] =  0;
		int i =-1;
		while (step[n-1] == -1)
		{
			i++;
			if (step[i] == -1) break;
			int j = i + A[i];
			if (j >= n-1) return step[i] +1;
			while(step[j] == -1) step[j--] = step[i]+1;
		}
		return step[n-1];
	}
};