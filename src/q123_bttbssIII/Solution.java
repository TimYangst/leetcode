package q123_bttbssIII;

public class Solution {
	
	
    public int maxProfit(int[] prices) {
    	if (prices.length <= 1) return 0; 
    	int[] f = new int[prices.length];
    
    	int bm = prices[0];
    	f[0] = 0;
    	int mm = 0;
    	int max =0;
    	int ii = 0;
    	
    	
    	for (int i =1;i< prices.length;i++)
    	{
    		if (prices[i] - bm >  mm) { 
    			mm = prices[i] - bm; 
    			if (f[ii] + mm > max) 
    				max =f[ii] + mm ; 
    		}
    		if (bm >prices[i]){
    			bm = prices[i];
    			ii =i;
    		}
    		f[i] = mm;
    	}
    	return max;
    }
}