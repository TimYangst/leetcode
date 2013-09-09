package q122_BestTimetoBuyandSellStockII;

public class Solution {
    public int maxProfit(int[] prices) {
     int bm = prices[0];
     int sum = 0;
     for (int i = 1;i< prices.length;i++)
     {
    	 if (prices[i] > bm){
    		 sum += (prices[i] - bm);
    		 bm = prices[i];
    	 } else {
    		 bm = prices[i];
    	 }
     }
     return sum;
    }
}