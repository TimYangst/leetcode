#include<vector>
#include<queue>
using namespace std;

class Solution {
	bool isOutside(vector<vector<char>> &board,int x,int y) {
		return  (x  < 0 || x >= board.size() || y < 0 || y >=board[0].size());
	}
public:
    void solve(vector<vector<char>> &board) {
		if (board.size() <= 2 || board[0].size() <= 2) return ;
		queue<int> qx,qy;
		int h = board.size(), w =  board[0].size();
		for  (int i = 0 ; i < h ; i ++){
			if (board[i][0] == 'O') { qx.push(i); qy.push(0); board[i][0] = 'T';}
			if (board[i][w -1] == 'O') { qx.push(i); qy.push(w-1); board[i][w-1]= 'T'; }
		}
		for (int j = 0; j < w ; j++) {
			if (board[0][j] == 'O') {qx.push(0); qy.push(j);board[0][j] = 'T';}
			if (board[h-1][j] == 'O') {qx.push(0);qy.push(j);board[h-1][j] = 'T'; }
		}
		while (qx.size() > 0 ){
			int x = qx.front();
			int y = qy.front();
			qx.pop();qy.pop();
			if (!isOutside(board,x -1,y) && board[x-1][y] == 'O') {
				board[x-1][y] = 'T';
				qx.push(x-1); qy.push(y);
			}
			if (!isOutside(board,x +1,y) && board[x+1][y] == 'O') {
				board[x+1][y] = 'T';
				qx.push(x+1); qy.push(y);
			}
			if (!isOutside(board,x,y-1) && board[x][y-1] == 'O') {
				board[x][y-1] = 'T';
				qx.push(x); qy.push(y-1);
			}
			if (!isOutside(board,x,y+1) && board[x][y+1] == 'O') {
				board[x][y+1] = 'T';
				qx.push(x); qy.push(y+1);
			}
		}
		for (int i = 0 ; i < board.size(); i++)
			for  (int j = 0; j<board[0].size(); j++){
				if (board[i][j]== 'O') board[i][j] = 'X';
				else if (board[i][j] == 'T') board[i][j] = 'O';
			}
    }
};
//int main () {
//	vector<char> ele(3,'X');
//	vector<vector<char>> map(3,ele);
//	map[1][1] = 'O';
//	Solution s;
//	s.solve(map);
//	
//
//}