#include <string>
using namespace std;

class Solution {
public:
    int removeDuplicates(int A[], int n) {
		int i,j;
		i = 0; j =0;

		while (j < n ){
			A[i++] = A[j++];
			if (j < n && A[j] == A[j-1]) { 
				while (j < n && A[j] == A[j-1]) j++;
				A[i++] = A[j-1];
			}
		}
		return i;
    }
};