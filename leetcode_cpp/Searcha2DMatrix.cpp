#include <vector>
using namespace std;

class Solution {
	int binarysearchline(vector<vector<int>> & matrix, int b, int e, int target){
		if (b >= e) return -1;
		if (b + 1 == e) return b;
		int mid = (b + e) >> 1;
		if (matrix[mid][0] <= target && target <= matrix[mid][matrix[0].size() -1] ){
			return mid;
		}
		if (matrix[mid][0] > target)return binarysearchline(matrix,b,mid,target);
		return binarysearchline(matrix,mid+1,e,target);
		
	}
	int binarysearchrow(vector<int> & row, int b,int e, int target){
		if (b >= e) return -1;
		if (b == e -1) return row[b] == target ? b : -1;
		int mid = (b + e) /2;
		if (row[mid] == target) return mid ;
		if (row[mid] > target) return binarysearchrow(row,b,mid,target);
		return binarysearchrow(row,mid+1,e,target);
	}
public:
    bool searchMatrix(vector<vector<int> > &matrix, int target) {
		if (matrix.size() == 0 || matrix[0].size() == 0) return false;
		int l = binarysearchline(matrix,0,matrix.size(),target);
		if (l == -1) return false;
		return binarysearchrow(matrix[l],0, matrix[0].size(),target) != -1;
    }
};