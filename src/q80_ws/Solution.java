package q80_ws;


public class Solution {
    public int removeDuplicates(int[] A) {
    	int length = A.length;
    	int i =0;
    	while (i < length)
    	{
    		
    		if (i < length -1 && A[i] == A[i+1])
    		{
    			i++;
    		}
    		
    		
    		int j = i + 1;
    		while (j <=  length -1 && A[j] == A[j-1])
    		{
    			j++;
    		}
    		if (j == length) 
    		{
    			length = i + 1;
    			break;
    		}
    		int deta = j- i-1;
    		if (deta !=0)
    		{
    			length -= deta;
    			for (int k = i +1 ;k<length;k++)
    			{
    				A[k] = A[k+ deta];
    			}
    		}
    		i++;
    	}
        return length;
    }
}