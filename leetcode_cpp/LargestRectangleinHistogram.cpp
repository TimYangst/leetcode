#include <vector>
#include<stack>
using namespace std;
class Solution {
public:
    int largestRectangleArea(vector<int> &height) {
		vector<int> width(height.size(),1);
		stack<int> lstack,rstack;
		for (int i =0 ;i< height.size(); i++){
			int k = i;
			while (lstack.size()>0 && height[lstack.top()]  >= height[i]) {
				k =  lstack.top();
				lstack.pop();
			}
			if (lstack.size()==0) width[i] += i;
			else width[i] += i - lstack.top() -1;
			lstack.push(i);
		}
		for (int i = height.size()-1;i>=0; i--){
			int k =  i;
			while (rstack.size() >0  && height[rstack.top()] >= height[i]){
				k=  rstack.top();
				rstack.pop();
			}
			if (rstack.size()==0) width[i] +=  height.size()-1- i;
			else width[i] +=  rstack.top() - i -1;
			rstack.push(i);
		}
		int rst = 0;
		for (int i = 0; i< height.size(); i++){
			rst = max (rst, height[i] * width[i]);
		}
		return rst;
    }
};