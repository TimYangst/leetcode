package q30_SubstringwithConcatenationofAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (L.length == 0 || L.length * L[0].length() > S.length()) return rst;
        
        Map<String, Integer> count = new HashMap<String,Integer>();
        for (String str : L )
        {
        	Integer ct = count.get(str);
        	ct = (ct == null) ? 1 : (ct +1) ;
        	count.put(str, ct);
        }
        for (int i = 0, j; i<= S.length() - L.length * L[0].length(); i++)
        {
        	Map<String,Integer> tmp = new HashMap<String,Integer>();
        	for (j = 0 ; j< L.length;j++){
        		String key = S.substring(i + j * L[0].length(), i+ (j+1)*L[0].length());
        		Integer old = count.get(key);
        		if (old == null) break;
        		Integer value = tmp.get(key);
        		value = (value == null) ? 1 : value +1;
        		if (value > old) break;
        		tmp.put(key, value);
        	}
        	if (j ==  L.length) rst.add(i);
        }
    	return rst;
    }
    public static void main(String[] args) {
		new Solution().findSubstring("barfoothefoobarman", new String[]{"foo","bar"});
	}
}