/*
 * Create date 2013-7-4
 *
 * @author YangTing
 *
 */


package q128_lcs;

import java.util.HashSet;
import java.util.Set;


public class Solution {
    public int longestConsecutive(int[] num) {
    	Set<Integer> set =  new HashSet<Integer>();
    	for (int i = 0 ;i<num.length;i++)
    	{
    		set.add(num[i]);
    	}
    	int min = 0;
    	for( int i = 0; i < num.length;i++)
    		if (set.contains(num[i]))
    		{
    			set.remove(new Integer(num[i]));
    			int k = num[i]-1;
    			while (set.contains(k))
    			{
    				set.remove(new Integer(k));
    				k--;
    			}
    			int  j = num[i] +1;
    			while (set.contains(j)){
    				set.remove(new Integer(j));
    				j++;
    			}
    			
    			if (j - k -1 > min) min = j - k -1;
    		}
    	return min;
    }
}