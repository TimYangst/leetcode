package q115_DistinctSubsequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int numDistinct(String S, String T) {
    	if (S == null || T == null) return 0;
    	if ("".equals(T)) return 1;
    	if (S.length() < T.length()) return 0;
        int[] count = new int[256];
        List<Integer>[] parray = new List[T.length()];
        Map<Character,List<Integer>> map = new HashMap<Character,List<Integer>>();
        
        for (int i =0 ;i< count.length; i++)  count[i] = 0;
        for (int i =0 ;i < T.length(); i++)
        {
        	count[T.charAt(i)] ++;
        	if (count[T.charAt(i)] == 1) {
        		ArrayList<Integer> ele = new ArrayList<Integer>();
        		map.put(T.charAt(i),ele);
        	}
        	parray[i] =  map.get(T.charAt(i));
        }
        for (int i =0 ;i< S.length() ;i ++)
        {
        	List<Integer> ele  = map.get(S.charAt(i));
        	if (ele != null) ele.add(i);
        }
        
        int[] a = new int[parray[0].size()];
        for (int i =0; i < a.length ; i++) a[i] = i+1;
        if (a.length == 0) return 0;
        for (int i=1;i < T.length();i++)
        {
        	int[] b = a;
        	a = new int[parray[i].size()];
        	if (a.length == 0) return 0;
        	int j =0;
        	int k =0;
        	int base = 0;
        	while (j < a.length && k < b.length){
        		if (parray[i].get(j) <=parray[i-1].get(k)) 
        		{
        			a[j] = base;
        			j++;
        		} else {
        			base = b[k];
        			k++;
        		} 
        	}
        	while (j < a.length)
        	{
        		a[j] = base;
        		j++;
        	}
        	if (a[j-1] == 0) return 0;
        	for (k = 1; k< a.length; k++) a[k] += a[k-1];
        }
        return a[a.length-1];
    }
    public static void main(String[] args) {
		new Solution().numDistinct("ddd", "dd");
	}
}