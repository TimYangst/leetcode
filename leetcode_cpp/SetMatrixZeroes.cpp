#include<vector>
using namespace std;
class Solution {
public:
    void setZeroes(vector<vector<int> > &matrix) {
		if (matrix.size() == 0 || matrix[0].size() == 0) return;
		int w =  matrix.size(), h = matrix[0].size();
		int r = -1, l = -1;
		for (int i = 0 ;i< w; i++ )
			for  (int j = 0 ;j < h ; j++) 
				if (matrix[i][j] == 0){
					if (r == -1){
						r = i ;l = j;
					}else {
						matrix[r][j] = 0;
						matrix[i][l] = 0;
					}
				}
		if (r == -1) return ;
		for  (int i = 0 ; i <w; i++) 
			if  (i != r && matrix[i][l] == 0){
				for  (int j = 0 ; j < h; j++)
					matrix[i][j] = 0;
			}
		for (int j = 0 ;j < h ; j++)
			if (j != l && matrix[r][j] == 0) {
				for (int i = 0; i < w; i++) 
					matrix[i][j] = 0;
			}
		for (int i = 0; i < w ;i++) matrix[i][l] = 0;
		for (int j = 0; j < h; j++) matrix[r][j] = 0;
    }
};