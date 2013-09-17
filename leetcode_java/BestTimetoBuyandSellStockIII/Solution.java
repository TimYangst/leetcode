package BestTimetoBuyandSellStockIII;

public class Solution {
    public int maxProfit(int[] prices) {
    	if (prices.length <= 1) return 0; 
    	int rst =0;
    	int[] firstTime = new int[prices.length];
    
    	int min = prices[0];
    	firstTime[0] = 0;
    	int max =0;
    	for (int i =1;i< prices.length;i++)
    	{
    		firstTime[i] = prices[i] - min;
    		if (firstTime[i-1] > firstTime[i])firstTime[i] = firstTime[i-1]; 
    		if (prices[i] < min) min = prices[i];
    	}
    	max = prices[prices.length-1];
    	for (int  i = prices.length -1 ;i>= 0 ;i-- )
    	{
    		if (max - prices[i] +  firstTime[i] >  rst ) 
    			rst = max - prices[i] +  firstTime[i];
    		if (prices[i] > max ) max = prices[i];
    	}
    	return rst;
    }
}