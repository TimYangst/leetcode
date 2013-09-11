class Solution {
public:
    void merge(int A[], int m, int B[], int n) {
        int i1 = m-1,i2 = n-1;
		int last =  m+n-1;
		while ( i1 >= 0 && i2 >=0){
			if (A[i1] > B[i2]) A[last--] = A[i1 --];
			else A[last--]= B[i2--];
		}
		while (i2 >= 0) A[last--] = B[i2--];
    }
};