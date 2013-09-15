#include <vector>
using namespace std;
class Solution {
public:
    void rotate(vector<vector<int> > &matrix) {
		int n =  matrix.size();
		if (n <= 1) return ;
		int mx =  (n +1) >>1 ;
		int my = n >> 1;
		for (int i = 0; i< mx ;i++){
			for (int j = 0; j< my ; j++){
				int tmp =  matrix[i][j];
				matrix[i][j] = matrix[n-j-1][i];
				matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
				matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
				matrix[j][n-i-1] = tmp;
			}
		}
    }
};