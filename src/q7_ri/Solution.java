package q7_ri;

public class Solution
{
	/*
	     	boolean tag = false; 
    	if ( x < 0 ) {
    		x = -x;
    		tag = true;
    	}
	 */
    public int reverse(int x) 
    {
    	int rst = 0;

    	while (x != 0)
    	{
    		rst = rst * 10 + x % 10 ;
    		x = x / 10;
    	}
        return rst;
    }
}
