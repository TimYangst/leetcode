package q53_ms;

public class Solution {
    public int maxSubArray(int[] A) {
        int max = A[0];
        int  g =0;
        for (int i =0;i<A.length;i++)
        {
        	if (g >0) g += A[i];
        	else g = A[i];
        	if (g > max) max = g;
        }
    	return max;
    }
}