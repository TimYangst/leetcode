package q019_LetterCombinationsofaPhoneNumber;

import java.util.ArrayList;

public class Solution {
	String[] map = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	
	private void find(int level, String digits, char[] tmp, ArrayList<String> rst)
	{
		char c = digits.charAt(level);
		String sql =  map[c-'0'];
		for (int i = 0;i<sql.length();i++)
		{
			char t = sql.charAt(i);
			tmp[level] = t;
			if (level == digits.length()-1)
			{
				rst.add(new String(tmp));
			}else
			{
				find(level+1,digits,tmp,rst);
			}
		}
	}
	
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> rst = new ArrayList<String>();
        
        if (digits == null ) return rst;
        if ( "".equals(digits.trim()) || digits.contains("1")) 
        {
        	rst.add("");
        	return rst;
        }
        char[] tmp = new char[digits.length()];
        find(0,digits,tmp,rst);
        return rst;
    	
    }
}
