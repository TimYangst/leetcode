package q68_TextJustification;

import java.util.ArrayList;

public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
    	ArrayList<String> rst = new ArrayList<String>();
    	if (L == 0 ) {
    		rst.add("");
    		return rst;
    	}
    	int j = 0;
    	while (j<words.length)
    	{
    		int i = j;
    		StringBuffer sb = new StringBuffer(words[i]);
    		int left = L - words[i].length();
    		i ++;
    		while (i < words.length && (words[i].length() + 1) <= left)
    		{
    			left -= words[i].length() +1;
    			i++; 
    		}
    		if (i - j == 1)
    		{
    			while (left > 0 )
    			{
    				sb.append(' ');
    				left --;
    			}
    		}else 
    		{
    			if (i == words.length)
    			{
    				for (int k = j+1;k<i;k++)
    				{
    					sb.append(' ');
    					sb.append(words[k]);
    				}
    				for (int u = 0;u<left;u++) sb.append(' ');
    			}else{
	    			int avg = left / (i - j - 1);
	    			int rank = left % (i - j -1);
	    			
	    			for (int k = j+1;k<i;k++)
	    			{
	    				sb.append(' ');
	    				for (int u = 0;u<avg;u++)sb.append(' ');
	    				if ( k - j <= rank ) sb.append(' ');
	    				sb.append(words[k]);
	    			}
    			}
    		}
    		rst.add(sb.toString());
    		j = i;
    	}
    	
        return rst;
    }
    public static void main(String[] args) {
		new Solution().fullJustify(new String[]{"What","must","be","shall","be."}, 12);
	}
}