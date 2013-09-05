package q120_Triangle;

import java.util.ArrayList;

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	if (triangle.size() == 0) return 0;
    	int[] f =  new int[1];
    	int[] g;
    	f[0] = triangle.get(0).get(0);
    	for (int i= 1;i< triangle.size();i++)
    	{
    		g = f;
    		f = new int[i+1];
    		f[0] = triangle.get(i).get(0) + g[0];
    		f[i] = triangle.get(i).get(i) + g[i-1];
    		for (int j= 1;j<i;j++)
    		{
    			f[j] = triangle.get(i).get(j);
    			if (g[j-1] < g[j]) f[j] += g[j-1];
    			else f[j] += g[j];
    		}
    	}
    	int min = f[0];
    	for (int i =1 ;i<triangle.size();i++) 
    		if  (f[i] < min ) min = f[i]; 
    	return min;
    }
}