package q88_msa;

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
    	int j = m-1;
    	int k = n-1;
    	for (int i =m + n -1 ;i>=0;i--)
    	{
    		if (j >=0 && k >=0)
    		{
    			if (A[j] >= B[k])
    				A[i] =  A[j--];
    			else A[i] = B[k--];
    		}
    		else if (j >=0) A[i] = A[j--];
    		else A[i] = B[k--];
    	}
    }
}