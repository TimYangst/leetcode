package q130_SurroundedRegions;
/*
 * Create date 2013-7-4
 *
 * @author YangTing
 *
 */

public class Solution {
    
    public boolean outbranch(int x, int y, int w, int h)
    {
        if (x < 0 || y < 0 || x >= w || y >= h)  return true;
        return false;
    }
    
    public void spread(char[][] board, int x, int y, int w, int h)
    {
        int[][] queue;
        int[][] arror = { {-1,0}, {1, 0 } , { 0 , -1} , {0 ,1} };
        
        int  b, e;
        b = 0;
        e = 1;
        queue =  new int[w*h+1][2];
        queue[1][0] = x;
        queue[1][1] = y;
        
        while (b < e)
        {
            b++ ;
            int x1 = queue[b][0];
            int y1 = queue[b][1];
            for (int i = 0 ;i< 4; i++) {
                int x2 = x1 + arror[i][0];
                int y2 = y1 + arror[i][1];
                if (! outbranch(x2,y2,w,h) && board[x2][y2] == 'O' )
                {
                    board[x2][y2] = 'E';
                    e ++;
                    queue[e][0] = x2;
                    queue[e][1] = y2;
                }
            }
            
        }
    }
    
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i,j;
        
        int w = board.length;
        int h = 0 ;
        if ( board == null || w  ==  0) return;
        h = board[0].length;
        if ( h == 0 ) return; 
        
        
        for (i = 0; i < w ; i++)
        {
            for ( j = 0; j < h ; j++)
            {
                if (board[i][j] == 'O')
                {
                    if (i == 0 || i == w - 1 || j == 0 || j == h - 1) {
                        board[i][j] = 'E';
                        spread(board, i, j,w,h);
                    }
                }
            }
        }
        for (i=0; i < w; i++)
            for (j =0; j < h; j++)
                if (board[i][j] == 'E') board[i][j] = 'O';
                else if (board[i][j] == 'O' ) board[i][j] = 'X';
        return;
    }

    public static void main(String[] args) {
		char[][] test = { {'O'}}; 
    	new Solution().solve(test);
	}
}