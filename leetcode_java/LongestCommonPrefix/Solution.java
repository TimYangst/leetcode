package LongestCommonPrefix;

public class Solution {
	public String longestCommonPrefix(String[] strs) {
        int  i = 0;
        if (strs.length == 0 ) return "";
        if (strs.length == 1 ) return strs[0];
        StringBuffer sb = new StringBuffer("");
        while (i < strs[0].length())
        {
        	
        	char c = strs[0].charAt(i);
        	int j;
        	for (j = 1; j < strs.length; j++)
        		if (i >=  strs[j].length() || c !=  strs[j].charAt(i))
        			return sb.toString();
        	sb.append(c);
        			
        	i++;
        }
        return sb.toString();
    }
	public static void main(String[] args) {
	 new Solution().longestCommonPrefix(new String[]{"",""});
	}	
}
