package q126_wlII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
	private boolean isConj(String a1, String a2) {
		int index = 0;
		int k = 0;
		while (index < a1.length()) {
			if (a1.charAt(index) != a2.charAt(index))
				k++;
			if (k > 1)
				return false;
			index++;
		}
		return k == 1;
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
		dict.remove(start);
		dict.remove(end);
		
		boolean[][] f = new boolean[dict.size() +2][];
		ArrayList<ArrayList<Integer>>[] paths = new ArrayList[dict.size() +2];
		
		for (int i = 0; i <= dict.size() + 1; i++)
		{
			f[i] =  new boolean[dict.size() + 2];
			paths[i] = new ArrayList<ArrayList<Integer>>();
		}
		int b = 0;
		int e = dict.size() +1;
		
		
		paths[b].add(new ArrayList<Integer>());
		String[] strs = new String[dict.size() + 2];
		strs[b] = start;
		strs[e] = end;
		
		int i = 1;
		Set<Integer> unpick =  new HashSet<Integer>();
		unpick.add(e);
		for (String str : dict) {unpick.add(i); strs[i++] = str; }
		for (int j = 0; j< strs.length-1;j++)
			for (int k = j+1; k< strs.length; k++)
				f[j][k] = f[k][j] = isConj(strs[j],strs[k]);
		
		Queue<Integer> indexqueue = new LinkedList<Integer>();
		Set<Integer> inthequeue = new HashSet<Integer>();
		indexqueue.add(b);
		while (indexqueue.size() > 0)
		{
			int current =  indexqueue.poll();
			if (paths[e].size() > 0 && paths[current].get(0).size() >= paths[e].get(0).size()) break;
			unpick.remove(new Integer(current));
			for (int  j :  unpick)
			{
				if (f[current][j])
				{
					if (paths[j].size() == 0 || paths[current].get(0).size() < paths[j].get(0).size())
					{
						for (ArrayList<Integer> path : paths[current])
						{
							ArrayList<Integer> newpath =  new ArrayList<Integer>();
							newpath.addAll(path);
							newpath.add(j);
							paths[j].add(newpath);
						}
					}
					if (!inthequeue.contains(j)) {
						inthequeue.add(j);
						indexqueue.add(j);
					}
				}
			}
		}
		for (ArrayList<Integer> path : paths[e])
		{
			ArrayList<String> ele = new ArrayList<String>();
			ele.add(start);
			for (int j  : path) ele.add(strs[j]);
			rst.add(ele);
		}
		return rst;
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