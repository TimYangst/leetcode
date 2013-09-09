package q33_SearchinRotatedSortedArray;

public class Solution {
	private int search(int[] A,int b, int e,int target)
	{
		if (b >= e) return -1;
		if (b + 1 == e){
			if (A[b] == target) return b;
			else return -1;
		}
		int mid = (b + e) / 2;
		if (A[mid] == target) return mid;
		if (A[b] < A[mid])
		{
			if (A[b] <= target && target < A[mid]) return search(A,b,mid,target);
			else return search(A,mid+1,e,target);
		}
		else 
		{
			if (A[mid] < target && target <= A[e-1] )return search(A,mid +1, e,target);
			else return search(A,b,mid,target);
		}
	}
	
    public int search(int[] A, int target) {
    	return search(A,0,A.length,target);
    }
}