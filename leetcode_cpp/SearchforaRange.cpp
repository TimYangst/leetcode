#include <vector>
using namespace std;
class Solution {
	int binaryfind(int A[],int b,int e,int target,int n,bool front){
		if (b >= e) return -1;
		if (b == e-1) return A[b] == target ? b : -1;
		int mid =  ( b + e ) >> 1;
		if (A[mid] > target) return binaryfind(A,b,mid,target,n,front);
		else if (A[mid] < target) return binaryfind(A,mid+1,e,target,n,front);
		if (front) {
			if (mid == 0 || A[mid -1] != target) return mid;
			return  binaryfind(A,b,mid,target,n,front);
		}else {
			if (mid == n-1 || A[mid+1] != target) return mid;
			return binaryfind(A,mid+1,e,target,n,front);
		}
	}
public:
    vector<int> searchRange(int A[], int n, int target) {
		vector<int> rst;
		rst.push_back(binaryfind(A,0,n,target,n,true));
		rst.push_back(binaryfind(A,0,n,target,n,false));
		return rst;
    }
};