
class Solution {
public:
    bool search(int A[], int n, int target) {
        int b = 0;
		int e = n-1;
		while (b <= e){
			if (b == e)  return A[b] == target;
			int m = b + (e - b) /2;
			if (A[m] == target) return true;
			if (A[b] < A[m]) {
				if (A[b] <= target && target < A[m]) e = m-1;
				else b =  m +1;
			} else if (A[m] < A[e]){
				if (A[m]< target && target <= A[e]) b = m+1;
				else e = m -1;
			}else if (A[b] == A[m]) b++;
			else if (A[m] == A[e]) e--;
		}
		return false;
    }
};