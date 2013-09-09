package q26_RemoveDuplicatesfromSortedArray;

public class Solution {
    public int removeDuplicates(int[] A) {
        int length = A.length;
        int i = 0;
        int j = 0;
        int k,deta;
        while (i < length)
        {
        	j = i;
        	while (j<length && A[j] == A[i] )
        	{
        		j++;
        	}
        	
        	deta = j - i -1;
        	i++;
        	if (deta > 0)
        	{
        		k = i;
        		length -= deta;
        		while (k < length)
        		{
        			A[k] = A[k+deta];
        			k++;
        		}
        	}
        }
        return length;
    }
}