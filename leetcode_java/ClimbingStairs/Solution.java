package ClimbingStairs;

public class Solution {
    public int climbStairs(int n) {
    	if (n < 0) return 0;
    	if (n ==  0) return 1;
    	if (n == 1) return 1;
    	if (n == 2)  return 2;
    	int a1 = 1, a2 = 2;
    	
    	for (int i = 3;i<=n;i++)
    	{
    		int k = a1 +a2;
    		a1 = a2;
    		a2 = k;
    	}
    	return a2;
        
    }
}