package RemoveElement;

import java.util.Arrays;

public class Solution {
	
	private int binarySearch(int[] A,int b, int e, int target)
	{
		if (b == e) return -1;
		if (b == e + 1) 
		{
			if (A[b] == target) return b;
			else return -1;
		}
		int mid = (b + e ) /2;
		if (A[mid] < target) return binarySearch(A, mid + 1, e, target);
		int rt =binarySearch(A, b, mid, target);
		if (rt != -1) return rt;
		if (A[mid] ==  target) return mid;
		else return -1;
	}
    public int removeElement(int[] A, int elem) {
    	Arrays.sort(A);
    	int length = A.length;
    	if (length == 0) return 0;
    	else if (length == 1)
    	{
    		if (A[0] == elem) return 0;
    		else return 1;
    	}
    	
    	int start = binarySearch(A,0,length,elem);
    	if (start == -1) return length;
    	int j = start;
    	
    	while (j < length && A[j] == A[start])
    	{
    		j++;
    	}
    
    	int deta = j - start;
    	length -= deta;
    	j = start;
    	while (j < length)
    	{
    		A[j] = A[j + deta];
    		j++;
    	}
        return length;
    }
}