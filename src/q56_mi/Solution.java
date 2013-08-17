package q56_mi;

import java.util.ArrayList;



class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}

public class Solution{

	private boolean cmp(Interval a1,Interval a2)
	{
		if (a1.start < a2.start || a1.start == a2.start && a1.end < a2.end) return true;
		return false;
	}
	private void sort(ArrayList<Interval> arr,int b,int e)
	{
		if (b >= e) return ;
		int i =b, j = e;
		Interval item =  arr.get(b);
		
		while (i < j)
		{
			while (i < j && cmp(item,arr.get(j))) j--;
			if (i < j) 
			{
				arr.set(i, arr.get(j));
				i++;
			}
			while (i < j && cmp(arr.get(i), item)) i++;
			if (i<j) {
				arr.set(j, arr.get(i));
				j--;
				
			}
		}
		arr.set(i, item);
		if (b < i -1) sort(arr,b,i-1);
		if (i+1< e) sort(arr,i+1,e);
	}
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    	ArrayList<Interval> rst = new ArrayList<Interval> () ;
    	if (intervals.size() == 0) return rst;
    	sort(intervals,0,intervals.size()-1);
    	int b = intervals.get( 0).start;
    	int e = intervals.get(0).end;
    	for (Interval inter : intervals)
    	{
    		if (inter.start <= e)
    		{
    			if (inter.end > e) e = inter.end;
    		} else {
    			Interval ele = new Interval(b, e);
    			rst.add(ele);
    			b = inter.start;
    			e = inter.end;
    		}
    	}
    	Interval ele =new Interval(b,e);
    	rst.add(ele);
    	return rst;
        
    }
}