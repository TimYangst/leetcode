package BestTimeToBuyAndSellStock;

public class Solution {
    public int maxProfit(int[] prices) {
    	if (prices.length == 0) return 0;
        int bm = prices[0];
        int max = 0;
        for (int i = 1; i< prices.length; i++)
        {
        	if (prices[i] - bm > max) max = prices[i] - bm;
        	if (prices[i] < bm) bm = prices[i];
        }
        return max;
    }
}