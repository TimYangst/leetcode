package q76_MinimumWindowSubstring;

import java.util.HashSet;
import java.util.Set;


public class Solution {
	
    public String minWindow(String S, String T) {
    	if (S == null || "".equals(S) || T == null || "".equals(T)) return "";
    	int[] count = new int[256];
    	int[] real = new int[256];
    	for (int i = 0 ; i< 256;i++)
    	{
    		count[i] = 0;
    		real[i] =0;
    	}
    	int tot = 0;
    	Set<Character> tset = new HashSet<Character>();
    	for (char c : T.toCharArray())
    	{
    		if (!tset.contains(c))
    		{
    			tset.add(c);
    			tot ++;
    		}
    		count[c] ++;
    	}
    	
    	int min = S.length() + 1;
    	
    	int b=0,e=0;
    	int ct =0;
    	int i =0;
    	int r=0,l=0;
 
    	while (i<S.length() && ct < tot)
    	{
    		if (tset.contains(S.charAt(i)))
    		{
    			
    			real[S.charAt(i)] ++ ;
    			if (real[S.charAt(i)] ==  count[S.charAt(i)])
    			{
    				ct++;
    				
    			}
    			while (b<i && (!tset.contains(S.charAt(b)) || real[S.charAt(b)] > count[S.charAt(b)]))
    			{
    				if  (tset.contains(S.charAt(b)))
    				{
    					real[S.charAt(b)]--;
    				}
    				b++;
    			}
    			
    		}
    		i++;
    	}
    	if (ct < tot) return "";
    	e = i;
    	l = b;
    	r = e;
    	min =e-b;
    	while (i<S.length())
    	{
    		if (tset.contains(S.charAt(i)))
    		{
    			e=i+1;
    			real[S.charAt(i)] ++;
    			while (!tset.contains(S.charAt(b)) || real[S.charAt(b)] > count[S.charAt(b)] )
    			{
    				if (tset.contains(S.charAt(b)))
    				{
    					real[S.charAt(b)] --;
    				}
    				b++;
    			}
    			if (e - b < min) 
    			{
    				min = e - b;
    				l = b;
    				r = e;
    			}
    		}
    		i++;
    	}
    	return S.substring(l,r);
    }
    
    public static void main(String[] args) {
		new Solution().minWindow("bbaa", "aba");
	}
}