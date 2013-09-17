package WordLadderII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
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

	public ArrayList<ArrayList<String>> findLadders(String start, String end,
			HashSet<String> dict) {
		ArrayList<ArrayList<String>> rst = new ArrayList<ArrayList<String>>();
		if (start.equals(end)) {
			ArrayList<String> ele = new ArrayList<String>();
			ele.add(start);
			rst.add(ele);
			return rst;
		}
		dict.add(start);
		dict.add(end);
		
		Map<String,ArrayList<ArrayList<String>>> paths =  new HashMap<String,ArrayList<ArrayList<String>>>(); 
		for (String str :  dict){
			paths.put(str, new ArrayList<ArrayList<String>>());
		}
				
		ArrayList<String> startpath = new ArrayList<String>();
		startpath.add(start);
		paths.get(start).add(startpath);
		
		Queue<String> queue = new LinkedList<String>();
		Set<String>	picked = new HashSet<String>();
		queue.add(start);
		picked.add(start);
		
		while (queue.size() > 0)
		{
			String current =  queue.poll();
			dict.remove(current);
			if (paths.get(end).size() > 0 && paths.get(current).get(0).size() >= paths.get(end).get(0).size()) break;
			
			Set<String> next = getNeighbour(current, dict);
			for (String str :  next)
			{
				if (paths.get(str).size() == 0 || paths.get(current).get(0).size() < paths.get(str).get(0).size())
				{
					{
						for (ArrayList<String> path : paths.get(current))
						{
							ArrayList<String> newpath =  new ArrayList<String>();
							newpath.addAll(path);
							newpath.add(str);
							paths.get(str).add(newpath);
						}
					}
					if (!picked.contains(str)) {
						queue.add(str);
						picked.add(str);
					}
				}
			}
		}
		return paths.get(end);
	}
	public static void main(String[] args) {
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("cog");
		dict.add("dog");
		dict.add("tot");
		dict.add("hog");
		dict.add("hop");
		dict.add("pot");
		dict.add("dot");
		new Solution().findLadders("hot", "dog", dict);
	}
}