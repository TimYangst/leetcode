package q72_EditDistance;

public class Solution {
    public int minDistance(String word1, String word2) {
    	if (word1 == null && word2 == null) return 0;
    	if (word1 == null || "".equals(word1)) return word2.length();
    	if (word2 == null || "".equals(word2)) return word1.length();
    	int[] f = new int[word2.length() +1];
    	int[] g;
    	f[0] = 0;
    	for (int i = 1; i <=word2.length();i++)
    	{
    		f[i] = i;
    	}
    	for (int  j = 1;j <= word1.length(); j++)
    	{
    		g = f;
    		f = new int[word2.length() +1];
    		f[0] = j;
    		for (int i = 1; i <= word2.length(); i++)
    		{
    			if (word1.charAt(j-1) ==  word2.charAt(i-1))
    			{
    				f[i] = g[i-1]; 
    			}else 
    			{
    				f[i] = Math.min(g[i-1],Math.min(f[i-1], g[i])) + 1;
    			}
    		}
    	}
    	
    	return f[word2.length()];
    }
}