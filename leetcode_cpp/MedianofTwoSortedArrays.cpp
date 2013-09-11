class Solution {
	double findMedian(int * A, int b,int e){
		if (b>= e) return 0;
		if ((e - b) % 2 ==1) return A[(b + e)/2];
		else return (A[(b+e-1)/2] + A[(b+e)/2]) / 2.0;
	}
	double findMedian(int * A1, int b1,int e1,int * A2,int b2,int e2){
		if (b1 >= e1) return findMedian(A2,b2,e2);
		if (b2 >= e2) return findMedian(A1,b1,e1);
		if (e1 - b1 > e2 -b2) return findMedian(A2,b2,e2,A1,b1,e1);
		int m11 = (b1+e1-1)/2, m12 = (b1+e1)/2;
		int m21 = (b2+e2-1)/2, m22 = (b2+e2)/2;
		if (e1 == b1+1) {
			if (e2 == b2+1) return (A1[b1] + A2[b2])/2.0;
			if ((e2 -b2) % 2 == 0) {
				if (A1[b1] < A2[m21]) return A2[m21];
				if (A1[b1] > A2[m22]) return A2[m22];
				return A1[b1];
			} else {
				if (A1[b1] < A2[m21 -1]) return (A2[m21-1] + A2[m21])/2.0;
				if (A1[b1] > A2[m22 +1]) return (A2[m21] + A2[m21+1])/2.0;
				return (A1[b1]+ A2[m21]) / 2.0;
			}
		}
		int deta = 0;
		if ((e1- b1)%2==0) deta = (m11-b1+1);
		else  deta = (m11 -b1);
		if (A1[m11] > A2[m21]) b2 += deta;
		else b1 += deta;
		if (A1[m12] < A2[m22]) e2 -= deta;
		else e1 -= deta;
		return findMedian(A1,b1,e1,A2,b2,e2);
	}
public:
    double findMedianSortedArrays(int A[], int m, int B[], int n) {
        return findMedian(A,0,m,B,0,n);
    }
};
//int main(){
//	int A[] = {1,2,3,8};
//	int B[] = {4,5,6,7};
//	Solution s;
//	s.findMedianSortedArrays(A,4,B,4);
//	return 0;
//}
