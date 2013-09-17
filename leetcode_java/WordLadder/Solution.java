package WordLadder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
	
	private Set<String> getNeighbour(String a1,Set<String> dict) {
		Set<String> rst = new HashSet<String>();
		char[] charArray = a1.toCharArray();
		for (int i = 0 ;i <  a1.length() ;i++){
			char c =  charArray[i];
			for (char t =  'a'; t<= 'z'; t++)
				if (t != c)
				{
					charArray[i] =  t;
					String newString =  new String(charArray);
					if (dict.contains(newString)){
						rst.add(newString);
					}
				}
			charArray[i] =  c;
		}
		return rst;
	}
	
    public int ladderLength(String start, String end, HashSet<String> dict) {
    	
        if (start == null || end == null) return 0;
        if (start.equals(end)) return 1;
		dict.remove(start);
		dict.add(end);
	
		Queue<String> queue = new LinkedList<String>();
		Queue<Integer> levelqueue = new LinkedList<Integer>();
		
		queue.add(start);
		levelqueue.add(1);
		
		while (queue.size() > 0 )
		{
			String current = queue.poll();
			Integer level =  levelqueue.poll();
			
			Set<String> nextSet =  getNeighbour(current, dict);
			for (String  next : nextSet)
			{
				if (next.equals(end))  return level +1;
				queue.add(next);
				levelqueue.add(level +1);
				dict.remove(next);
			}
		}
    	return 0;
    }
}