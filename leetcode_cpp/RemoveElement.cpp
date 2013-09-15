#include <string>
using namespace std;
class Solution {
public:
    int removeElement(int A[], int n, int elem) {
        int i = 0, j = 0;
		while (j < n){
			if (A[j] == elem) j++;
			else A[i++]=A[j++];
		}
		return i;
    }
};