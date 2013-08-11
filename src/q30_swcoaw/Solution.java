package q30_swcoaw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        
    	ArrayList<Integer>  rst = new ArrayList<Integer>();
    	
    	Map<String,Integer>  map = new  HashMap<String, Integer>();
    	Integer nb = 0;
    	for (String str : L)
    	{
    		map.put(str, nb);
    		nb ++;
    	}
    	
    	
    	if (S == null || L.length == 0) return rst;
    	
    	int l = L[0].length();
    	
    	int i,j;
    	
    	for (i=0; i < l; i++)
    	{
    		Integer f[] = new Integer[S.length() / l +1];
    		int k =0;
    		j = i;
    		while ( j + l < S.length())
    		{
    			String str = S.substring(j,j+l);
    			f[k++] = map.get(str);
    			j = j+l;
    		}
    		int[] count = new int[L.length];
    		for (int ii =  0;ii< count.length; ii++) count[ii] = 0;
    		int num = 0;
    		int u =0,v = 0;
    		while (u < k)
    		{
    			if (f[u] == null)
    			{
    				u++;
    				v=u;
    				num = 0;
    				for (int ii =  0;ii< count.length; ii++) count[ii] = 0;
    			}
    			else 
    			{
    				count[f[u]] ++;
    				if (f[u] == 1) num ++;
    				else if (f[u] == 2) num --;
    				if (u -v >= L.length)
    				{
    					count[f[u-L.length]] --;
    					if (f[u -L.length] == 1) num ++;
    					else if (f[u-L.length] == 0) num --;
    				}
    				if (num == L.length)
    				{
    					rst.add(i + (u - L.length +1) *l);
    				}
    				
    				u++;
    			}
    		}
    	}
    	
    	return rst;
    }
}