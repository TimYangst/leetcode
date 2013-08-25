package q11_cwmw;


	public class Solution {
	    public int maxArea(int[] height) {
	    	int max = 0;
	    	int i=0;
	    	int j=height.length-1;
	    	int h1 =height[i];
	    	int h2 = height[j];
	    	while (i<j)
	    	{
	    		if (height[i] > h1) h1 = height[i];
	    		if (height[j] > h2) h2 = height[j];
	    		if (Math.min(h1,h2) * ( j - i) > max)
	    			max = Math.min(h1, h2) * ( j - i);
	    		if (h1 == h2) 
	    		{
	    			i++;j--;
	    		}else if (h1 < h2) i++;
	    		else j--;
	    	}
	        return max;
	    }
	}
