package StringtoInteger;

public class Solution {
	
	private boolean isDegit(char c)
	{
		return '0' <= c && c <= '9';
	}
	private boolean isTag(char c)
	{
		return c == '-' || c == '+';
	}
	private String filter(String str)
	{
		StringBuffer sb = new StringBuffer();
		int i=0;
		while (str.charAt(i) == ' ') i++;
		if (isTag(str.charAt(i))){
			sb.append(str.charAt(i));
			i++;
		} else sb.append('+');
		boolean zero = true;
		while (i < str.length())
		{
			if (isDegit(str.charAt(i)))
			{
				if (!zero  || str.charAt(i) != '0')
				{
					sb.append(str.charAt(i));
					zero = false;
				}
			} 
			else
			{
				break;
			}
			i++;
		}
		return sb.toString();
	}
	private boolean isBigger(String str , String target)
	{
		if (str.length() > target.length()) return true;
		if (str.length() < target.length()) return false;
		return str.compareTo(target) > 0 ;
	}
	
	private boolean overfloor(String str,boolean negtive)
	{
		String target = null;
		if (negtive) target = String.valueOf(Integer.MIN_VALUE).substring(1);
		else target = String.valueOf(Integer.MAX_VALUE);
		return isBigger(str, target);
	}
    public int atoi(String str) {
    	if (str == null || "".equals(str.trim())) return 0;
    	str = filter(str);
    	if (str.length() == 0) return 0;
    	boolean negtive = (str.charAt(0) == '-');
    	str = str.substring(1);
    	if (overfloor(str, negtive)) 
    	{
    		if (negtive) return Integer.MIN_VALUE;
    		else return Integer.MAX_VALUE;
    	}
    	int k = negtive ? -1 : 1;
    	int rst = 0;
    	int i =0;
    	while (i < str.length())
    	{
    		rst = rst * 10 +  k * (str.charAt(i) - '0');
    		i++;
    	}
    	return rst;
    }
    
    public static void main(String[] args) {
		new Solution().atoi("-123");
	}
}