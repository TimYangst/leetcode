#include <vector>
#include <stack>
using namespace std;
class Solution {
	void search(int level, int vertical,int obliqueUp,int obliqueDown, int n, int & rst){
		for  (int i = 0 ; i < n; i++ ){
			if  ((vertical & (1 << i)) || (obliqueUp &(1 << (i + level))) || (obliqueDown & (1 << (i - level + n - 1)))){
				continue;
			} else if (level == n -1) {
				rst ++;
				return;
			} else {
				search(level+1,vertical | (1 << i),obliqueUp |(1 << (i + level)),obliqueDown | (1 << (i - level + n - 1)),n,rst);
			}
		}
	}

public:
    int totalNQueens(int n) {
		if (n == 1) return 1;
		if (n <= 3) return 0;
		int rst = 0;
		int vertical = 0,obliqueUp = 0, obliqueDown = 0;
		search(0,vertical,obliqueUp,obliqueDown,n,rst);
		return rst;
	}
};