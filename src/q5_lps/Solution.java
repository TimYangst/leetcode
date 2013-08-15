package q5_lps;
public class Solution {
	private boolean checkPalindromic(String str)
	{
		for (int i = 0;i < str.length() /2; i++)
		{
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) 
				return false;
		}
		return true;
	}
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if (s == null || "".equals(s.trim())) return s;
    	for (int i = s.length() ; i >= 1 ; i-- )
    	{
    		for (int j = 0; j < s.length() - i + 1 ; j ++ )
    		{
    			if (checkPalindromic(s.substring(j,j+i)))
    			{
    				return s.substring(j, j+i);
    			}
    		}
    		
    	}
        return null;
    }
}