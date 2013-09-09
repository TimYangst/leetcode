package q97_InterleavingString;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
    	if (s1 == null ) s1 = "";
    	if (s2 == null) s2 = "";
    	if ("".equals(s1)) return s2.equals(s3);
    	if ("".equals(s2)) return s1.equals(s3);
    	if (s3.length() != s1.length() + s2.length()) return false;
    	Boolean[][] f = new Boolean[s1.length()+1][];
    	for (int i = 0; i< f.length;i++) f[i] = new Boolean[s2.length()+1];
    	f[0][0]=true;
    	for (int  i = 1; i<=s1.length() ;i++)
    		f[i][0]  = (f[i-1][0] && s3.charAt(i-1) == s1.charAt(i-1)); 
    	for (int j = 1; j <= s2.length(); j++)
    		f[0][j] = (f[0][j-1] && s3.charAt(j-1) == s2.charAt(j-1));
    	for (int i =1; i<= s1.length();i++)
    		for (int j = 1;j<=s2.length();j++)
    		{
    			f[i][j] = false;
    			if (f[i-1][j] && s3.charAt(i+j-1) == s1.charAt(i-1)) f[i][j] = true;
    			if (f[i][j-1] && s3.charAt(i+j-1) == s2.charAt(j-1)) f[i][j] = true;
    		}
    	return f[s1.length()][s2.length()];
    }
    public static void main(String[] args) {
		new Solution().isInterleave("a", "b", "ab");
	}
}