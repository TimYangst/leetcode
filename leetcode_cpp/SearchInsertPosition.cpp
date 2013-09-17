class Solution {
public:
    int searchInsert(int A[], int n, int target) {
		int b = 0;
		int e = n;
		while (b < e) {
			int mid = b + (e -b)/2;
			if (A[mid] == target) return mid ;
			if (A[mid] > target) e = mid;
			else b = mid +1;
		}
        return b;
    }
};