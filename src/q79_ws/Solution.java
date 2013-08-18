package q79_ws;

public class Solution {
	
	private int[] fx = {1,0,-1,0};
	private int[] fy = {0,1,0,-1};
	
	private boolean search(int x,int y,String word, int index,char[][] board, boolean[][] map)
	{
		if (board[x][y] != word.charAt(index)) return false;
		map[x][y] = true;
		index ++;
		if (index ==  word.length()) return true;
		for (int i =0;i<4;i++)
		{
			int x1 = x + fx[i];
			int y1 = y + fy[i];
			if (0 <= x1 && x1 < board.length && 0<= y1 && y1 < board[0].length  && map[x1][y1] == false)
			{
				if (search(x1,y1,word,index,board,map))
					return true;
			}
		}
		map[x][y] = false;
		index --;
		return false;
	}
	
    public boolean exist(char[][] board, String word) {
    	if (word == null) return false;
    	if ("".equals(word)) return true;
    	if (board.length ==0 ||board[0].length==0) return false;
    	boolean[][] map = new boolean[board.length][];
    	for (int i = 0; i < board.length; i ++)
    	{
    		map[i] =  new boolean[board[0].length];
    		for (int j =  0; j<map[i].length; j++) map[i][j] = false;
    	}
    	for (int i=0;i<board.length;i++)
    		for (int j = 0;j<board[0].length;j++)
    		{
    			if (search(i,j,word,0,board,map)) return true;
    		}
        return false;
    }
}