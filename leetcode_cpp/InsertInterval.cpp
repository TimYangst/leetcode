#include <vector>
#include <algorithm>
using namespace std;
struct Interval {
      int start;
      int end;
      Interval() : start(0), end(0) {}
      Interval(int s, int e) : start(s), end(e) {}
  };
class Solution {
public:
    vector<Interval> insert(vector<Interval> &intervals, Interval newInterval) {
		vector<Interval> rst;
		int i = 0;
		while (i <intervals.size() && intervals[i].end < newInterval.start ) {
			rst.push_back(intervals[i]);
			i++;
		}
		while (i < intervals.size() && intervals[i].start <= newInterval.end){
			newInterval.start = min(newInterval.start,intervals[i].start);
			newInterval.end = max(newInterval.end,intervals[i].end);
			i++;
		}
		rst.push_back(newInterval);
		while (i<intervals.size()){
			rst.push_back(intervals[i]);
			i++;
		}
		return rst;
    }
};