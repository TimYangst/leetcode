#include <vector>
#include <algorithm>
using namespace std;
struct Interval {
      int start;
      int end;
      Interval() : start(0), end(0) {}
      Interval(int s, int e) : start(s), end(e) {}
  };
/*
bool cmp (const Interval &  a1,const Interval & a2){
	return (a1.start == a2.start)? (a2.end >a1.end):(a1.start<a2.start);
}  
*/

class cmp {
public :
	bool operator () (const Interval &  a1,const Interval & a2){
		return (a1.start == a2.start)? (a2.end >a1.end):(a1.start<a2.start);
	}  
};
class Solution {
	
public:
    vector<Interval> merge(vector<Interval> &intervals) {
		sort(intervals.begin(),intervals.end(),cmp());
		vector<Interval> rst ;
		if (intervals.size() ==0 )return rst;
		Interval current(intervals[0].start,intervals[0].end);
		for (int i = 1; i< intervals.size(); i++){
			if (intervals[i].start > current.end) {
				
				rst.push_back(current);
				current = intervals[i];
			}else {
				current.end = max(current.end,intervals[i].end);
			}
		}
		rst.push_back(current);
		return rst;
    }
};