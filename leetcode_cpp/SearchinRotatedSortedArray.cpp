class Solution {
public:
    int search(int A[], int n, int target) {
        int b = 0, e = n-1;
		while (b <= e ){
			int  mid =  b + (e-b) / 2;
			if (A[mid] == target) return mid;
			if (A[b] <= target && target <= A[mid]) e=mid -1;
			else if (A[mid] <= target && target <= A[e]) b = mid +1;
			else if (A[b] <= A[mid]) b = mid +1;
			else e = mid -1;
		}
		return -1;
    }
};