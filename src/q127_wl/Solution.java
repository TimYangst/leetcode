//package q127_wl;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Solution {
//	private boolean isConj(String a1, String a2)
//	{
//		int index = 0;
//		int k =0;
//		while (index < a1.length())
//		{
//			if (a1.charAt(index) != a2.charAt(index)) k ++;
//			index ++;
//		}
//		return k ==1;
//	}
//	
//    public int ladderLength(String start, String end, HashSet<String> dict) {
//    	 ArrayList<ArrayList<String>> rst = new ArrayList<ArrayList<String>>();
//         if (start == null || end == null) return rst;
//		dict.remove(start);
//		dict.add(end);
//	
//	
//		int b=0, e=0;
//		
//		for (int i = 0; i< next.length;i++)
//		{
//			visited[i] =0;
//			next[i] =  new LinkedList<Integer>();
//			if (strs[i].equals(start)) b = i;
//			if (strs[i].equals(end)) e = i; 
//		}
//		if (b == e) return 1;
//		for (int i =0;i< strs.length -1; i++)
//			for (int j = i+1; j< strs.length;j++)
//			{
//				//if (i == b  && j == e || i ==e && j == b) continue;
//				if (isConj(strs[i],strs[j])){
//					next[i].add(j);
//					next[j].add(i);
//				}
//			}
//		
//		Queue<Integer> sq = new LinkedList<Integer>();
//		sq.add(b);
//		
//		visited[b] = 1;
//		int min = -1;
//		while (sq.size() != 0 )
//		{
//			int k = sq.poll();
//			int level = visited[k];
//			if (level > min) break;
//			List<Integer> nl =  next[k];
//			for (int i : nl)
//			{
//				if (visited[i] != 0 && visited[i] * level <0)
//				{
//					return Math.abs(level) + Math.abs(visited[i]);
//				}
//				if (visited[i] == 0)
//				{
//					sq.add(i);
//					if (level >0 ) visited[i] =  level+1;
//					else visited[i] = level -1;
//				}
//			}
//		}
//		
//    	return 0;
//    }
//}