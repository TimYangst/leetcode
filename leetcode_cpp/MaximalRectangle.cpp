#include <vector>
#include <stack>
using namespace std;
class Solution {
public:
    int maximalRectangle(vector<vector<char> > &matrix) {
		if (matrix.size() == 0)  return 0;
		if (matrix[0].size() == 0) return 0;
		vector<int> current(matrix[0].size(),0);
		int rst = 0;
		for (int ii  =0;ii<matrix.size();ii++){
			for (int i = 0 ;i<matrix[0].size(); i++ ){
				if (matrix[ii][i] == '0') current[i] =0;
				else current[i] ++;
			}
			vector<int> width(matrix[0].size(),1);
			stack<int> lstack;
			for (int i = 0; i < matrix[0].size();i++){
				if (current[i] == 0) lstack.push(i);
				else {
					while (lstack.size()>0 && current[lstack.top()]>= current[i]) lstack.pop();
					if (lstack.size()>0) width[i] += i-lstack.top()-1;
					else width[i] += i;
					lstack.push(i);
				}
			}
			stack<int> rstack;
			for (int i = matrix[0].size()-1; i >=0; i--){
				if (current[i] == 0) rstack.push(i);
				else {
					while (rstack.size()>0 && current[rstack.top()] >= current[i]) rstack.pop();
					if (rstack.size()>0) width[i] += rstack.top()-i -1;
					else width[i] += matrix[0].size()-i-1;
					rstack.push(i);
				}
			}
			
			for (int i = 0; i< matrix[0].size();i++){
				rst = max(rst,current[i] * width[i]);
			}
		}
		return rst;
    }
};