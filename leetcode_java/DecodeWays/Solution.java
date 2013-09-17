package DecodeWays;

public class Solution {
    public int numDecodings(String s){
    	if (s == null) return 0;
    	if (s.length() == 0) return 0;
    	int[] f = new int[s.length() + 1];
    	
    	f[0] = 1;
    	if (s.charAt(0) == '0' ) return 0;
    	else f[1] = 1;
    	char c = s.charAt(0);
    	for (int i = 2; i<=s.length(); i++)
    	{
    		int t = (c - '0') *10 + s.charAt(i-1) -'0';
    		f[i] = 0;
    		if (10 <= t  && t <= 26) f[i] += f[i-2];
    		if (s.charAt(i-1) != '0' )  f[i] += f[i-1];
    		c = s.charAt(i-1);
    		if (f[i] == 0 && f[i-1] == 0) return 0;
    	}
    	return f[s.length()];
    }
}