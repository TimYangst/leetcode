package PalindromePartitioningII;

public class Solution {
    public int minCut(String s) {
        if (s== null || s.length() == 0) return 0;
        Boolean[][] f = new Boolean[s.length()][];
        for (int i =0 ;i<s.length();i++)
        {
            f[i] = new Boolean[s.length()];
            f[i][i] =  true;
            if (i < s.length() -1) f[i][i+1]  = (s.charAt(i) == s.charAt(i+1));
        }
        for (int j = 2; j < s.length();j++) 
            for (int  i = 0 ;i < s.length()-j; i++)
        	{
        		if (s.charAt(i) == s.charAt(i+j)) f[i][i+j] = f[i+1][i+j-1];
        		else f[i][i+j] = false;
        	}
        int[] g = new int[s.length()+1];
        g[0] = 0;
        g[1] = 0;
        for (int i = 2 ;i<=s.length();i++)
        {
            g[i] = g[i-1]+1;
        	if (f[0][i-1]) g[i] = 0;
        	else{
        		for (int j = 1 ; j < i;j++)
        		{
        			if (f[j][i-1] && g[j] + 1 < g[i]) g[i] = g[j]+1;
        		}
        	}
        }
        return g[s.length()];
    }
}