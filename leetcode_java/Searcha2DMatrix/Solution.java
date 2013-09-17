package Searcha2DMatrix;

public class Solution {
	
	private int searchrow(int[][] matrix,int target,int b,int e)
	{
		if (b >= e)  return -1;
		if (b == e-1 ) return b;
		int mid = (b + e) /2;
		if (matrix[mid][0] <= target && target <= matrix[mid][matrix[mid].length -1] ) return mid;
		if (matrix[mid][0] > target ) return searchrow(matrix,target,b, mid);
		return searchrow(matrix,target,mid+1,e);
		
	}
	
	private int binarysearch(int[] arr,int target,int b, int e)
	{
		if (b >= e) return -1;
		if (b == e - 1) 
			if (arr[b] ==  target) return b;
			else return -1;
		int mid = (b + e) /2;
		if (arr[mid] == target) return mid;
		if (arr[mid] >  target) return binarysearch(arr, target, b, mid);
		return binarysearch(arr, target, mid+1, e);
	}
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0  || matrix[0].length == 0) return false;
        if (matrix.length == 1) return (binarysearch(matrix[0],target, 0, matrix[0].length) != -1);
    	int k = searchrow(matrix,target,0,matrix.length);
    	if (k == -1) return false;
    	return (binarysearch(matrix[k],target,0,matrix[k].length) != -1);
    }
}
