package FirstMissingPositive;

public class Solution {
	public int firstMissingPositive(int[] A) {
		if (A.length == 0)
			return 1;
		boolean[] f = new boolean[A.length+1];
		for (int  i=0;i<=A.length; i++) f[i] = false; 
		for (int  i = 0 ;i< A.length ;i++)
		{
			if (A[i] > 0 && A[i] <= A.length + 1)
			{
				f[A[i] -1] =true;
			}
		}
		int j = 0;
		while ( f[j] )
		{
			j++;
		}
		return j + 1 ;
	}
}