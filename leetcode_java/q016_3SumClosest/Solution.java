package q016_3SumClosest;

import java.util.Arrays;

public class Solution {
	
    public int threeSumClosest(int[] num, int target) {
    	
    	Arrays.sort(num);
    	
    	int min = Math.abs(num[0] + num[1] + num[2] - target);
    	int rst = num[0] + num[1] + num[2];
    	for (int i = 0 ; i < num.length - 2; i++ )
    	{
    		int k = num.length -1;
    		for ( int  j = i +1; j< num.length -1; j++)
    		{
    			 if (Math.abs(num[i] + num[j] + num[k] -target) <  min)
    			 {
    				 min = Math.abs(num[i] + num[j] + num[k] -target);
    				 rst = num[i] + num[j] + num[k];
    			 }
    			 while (k > j + 1 && num[i] + num[j] + num[k-1] > target ) 
    			 {
    				 k -- ;
    				 if (Math.abs(num[i] + num[j] + num[k] -target) <  min)
    				 {
        				 min = Math.abs(num[i] + num[j] + num[k] -target);
        				 rst = num[i] + num[j] + num[k];
    				 }
    			 }
    			 if (k > j +1 && Math.abs(num[i] + num[j] + num[k-1] -target) < min)
    			 {
    				 min =  Math.abs(num[i] + num[j] + num[k-1] -target);
    				 rst = num[i] + num[j] + num[k-1];
    			 }
    		}
    	}
    	return rst;
    }
}