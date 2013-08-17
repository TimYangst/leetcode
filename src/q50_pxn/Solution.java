package q50_pxn;

public class Solution {
	public static double zero = 1e-8;
    public double pow(double x, int n) {
    	if ( n == 0 )  	return 1;
    	if (Math.abs(x) <zero) return 0;
    	double rst = 1;
    	double current =  x;
    	if (n < 0)  current = 1/x;
    	int k =  n;
    	while (k !=0 )
    	{
    		if (k % 2 != 0) rst *= current;
    		k = k / 2;
    		current *= current;
    	}
    	return rst;
    }
}