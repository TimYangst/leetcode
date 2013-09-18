class Solution {
	int MedianSearch(int * A, int la, int * B, int lb, int left, int right, int k){
		if (left > right) return MedianSearch(B, lb, A, la, 0, lb -1, k);
		int middle =  left + (right - left) / 2;
		if (middle + 1 > k) return MedianSearch(A,la,B,lb,left,middle-1,k);
		if (lb + middle + 1 < k) return MedianSearch(A,la,B,lb,middle+1,right,k);
		if ((middle + 1 == k|| B[k -(middle + 1)-1] <= A[middle] )&& (middle + 1 + lb == k || A[middle] <= B[k - middle -1]) ) return A[middle];
		else if (middle + 1 < k && B[k-(middle+1)-1] > A[middle] ) return MedianSearch(A,la,B,lb,middle+1,right,k);
		return MedianSearch(A,la,B,lb,left,middle-1,k);
	}
public:
    double findMedianSortedArrays(int A[], int m, int B[], int n) {
		int k = (m + n + 1) / 2;
		if (( m + n ) % 2 == 1 )return MedianSearch(A,m,B,n,0,m-1,k);
		else return (MedianSearch(A,m,B,n,0,m-1,k) + MedianSearch(A,m,B,n,0,m-1,k+1)) / 2.0;
    }
};
//int main ()
//{
//	Solution s;
//	int a[] = {1,2};
//	int b[] = {1,2};
//	s.findMedianSortedArrays(a,2,b,2);
//}