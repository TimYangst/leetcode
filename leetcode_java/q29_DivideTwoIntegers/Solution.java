package q29_DivideTwoIntegers;

public class Solution {
	private int[] docalc(int a1, int a2)
	{
		
		if (a1 > a2) 
		{
			return new int[] {0, a1};
		}
		if (a1 - a2 > a2)
		{
			return new int[]{1, a1 -a2};
		}
		
		int[] tmp = docalc(a1, (a2  + a2));
		
		if (tmp[0] == 0)
		{
			return new int[] {1, a1 -a2}; 
		} else
		{
			tmp[0] = tmp[0] + tmp[0];
			if (tmp[1] <= a2)
			{
				tmp[0] += 1;
				tmp[1] -= a2;
			} 
			return tmp;
		}
		
	}
	
    public int divide(int dividend, int divisor) {
    	int a1  =  dividend;
    	int a2 =  divisor;
    	boolean positive = true;
    	if (a1  >= 0 )
    	{
    		a1 = -a1;
    	} else 
    	{
    		positive = ! positive;
    	}
    	if (a2 >= 0)
    	{
    		a2 = -a2;
    		
    	} else 
    	{
    		positive = ! positive;
    	}
    	
    	int[] rst = docalc(a1, a2);
    	if (!positive) return -rst[0];
    	else return rst[0];
    }
}