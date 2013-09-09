package q35_SearchInsertPosition;

public class Solution {
	private int search(int[]A,int b,int e,int target)
	{
		if (b >= e) return b;
		if (b + 1 == e)
		{
			if (A[b] >= target) return b;
			return e;
		}
		int mid = (b + e) /2;
		if (A[mid] == target) return mid;
		if (A[mid] > target) return search(A,b,mid,target);
		return search(A,mid+1,e,target);
	}
    public int searchInsert(int[] A, int target) {
        return search(A,0,A.length,target);
    }
}