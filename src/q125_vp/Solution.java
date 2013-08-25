package q125_vp;

public class Solution {
	private boolean isChar(char c)
	{
		return 'a' <= c && 'z' >= c || 'A'<=c && 'Z' >=c || '0' <= c && '9' >= c ;
	}
	private char toLowCase(char c)
	{
		if ('A' <= c && 'Z' >= c) { return (char) (c - 'A' + 'a'); }
		return c;
	} 
    public boolean isPalindrome(String s) {
    	if (s == null || s.length() == 0) return true;
    	int i =0;
    	int j = s.length()-1;
    	while (i  < j)
    	{
    		if (!isChar(s.charAt(i))){ i++; continue;};
    		if (!isChar(s.charAt(j))){ j--; continue;};
    		if (toLowCase(s.charAt(i)) == toLowCase(s.charAt(j))) { i++;j--;}
    		else return false;
    	}
    	return true;
    }
}