package q81_SearchinRotatedSortedArrayII;

public class Solution {
	
	private boolean binarySearch(int [] A, int target,int b,int e)
	{
		if (b >= e) return false;
		if (b == e - 1) return (A[b] == target);
		int mid =  (b + e) /2;
		if (A[mid] == target) return true;
		if (A[b] < A[mid]) 
		{
			if (A[b] <=target && target < A[mid]) return binarySearch(A,target,b,mid);
			else return binarySearch(A,target,mid + 1,e);
		}
		if (A[mid] < A[e-1])
		{
			if (A[mid] < target && target <= A[e-1]) return binarySearch(A,target,mid+1,e);
			return binarySearch(A,target,b,mid);
		}
		int i =  b, j =  e-1;
		while (i<= j)
		{
			if (A[i] == target || A[j] ==  target) return true;
			i++;j--;
		}
		return false;
	}
	
	
    public boolean search(int[] A, int target) {
        return binarySearch(A, target,0,A.length);
    }
}