package InsertInterval;

import java.util.ArrayList;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class Solution {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		ArrayList<Interval> rst = new ArrayList<Interval>();
		if (intervals.size() == 0) {
			rst.add(new Interval(newInterval.start, newInterval.end));
			return rst;
		}
		int b, e;
		b = -1;
		e = -1;

		for (Interval ele : intervals) {
			if (ele.start > e) {

				if (e != -1) {
					Interval newEle = new Interval(b, e);
					rst.add(newEle);
				}
				if (newInterval.start > e && newInterval.end < ele.start) {
					rst.add(new Interval(newInterval.start, newInterval.end));
				}
				b = ele.start;
				e = ele.end;
				if (newInterval.start < b && newInterval.end >= b)
					b = newInterval.start;
				if (newInterval.start <= e && newInterval.end > e)
					e = newInterval.end;
			} else {
				if (ele.end > e)
					e = ele.end;
			}
		}
		rst.add(new Interval(b, e));
		if (newInterval.start > e) {
			rst.add(new Interval(newInterval.start, newInterval.end));
		}
		return rst;

	}
}