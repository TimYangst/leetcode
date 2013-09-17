package GrayCode;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> grayCode(int n) {
    	ArrayList<Integer> rst = new ArrayList<Integer>();
    	
    	int tot = 1<< n;
    	for (int i = 0; i < tot ;i++ )
    	{	
    		int l = 1;
    		int k = l << 1;
    		int t =0;
    		for (int j = 0; j<n ;j++)
    		{
    			int u =  i / l;
    			int v =  i / k;
    			if (v % 2 == 0)
    			{
    				t += (u % 2) * l;  
    			} else
    			{
    				t += (1- u % 2) * l;
    			}
    			l = k;
    			k = k << 1;
    		}
    		rst.add(t);
    	}
    	return rst;
    	
    }
}