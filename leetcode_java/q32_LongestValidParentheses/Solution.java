package q32_LongestValidParentheses;

public class Solution {
    public int longestValidParentheses(String s) {
    	int rst = 0;
    	int[] f = new int[s.length() + 1];
    	for (int i = 0; i<= s.length() ; i++) f[i] = 0;
    	for (int  i = s.length() - 2; i>=0 ;i--)
    	{
    		if (s.charAt(i) == '(')
    		{
    			int j = i +1;
    			int k = 1;
    			while (j < s.length()- k + 1 && k > 0)
    			{
    				if (s.charAt(j) == ')') k--;
    				else k ++;
    				j ++;
    			}
    			if (k == 0)
    			{
    				f[i] = f[j] + j - i;
    				if (f[i] > rst) rst = f[i];
    			}
    			
    		}
    		
    	}
    	return rst ;
    }
}