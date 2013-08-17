package q37_ss;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	@SuppressWarnings("unchecked")
	Set<Integer>[][] choice = new Set[3][9];
	
	private void add(int i, int j,int value,char[][] board)
	{
		board[i][j] =(char) (value + '0');
		choice[0][i].add(value);
		choice[1][j].add(value);
		choice[2][(j/3)*3 +(i/3)].add(value);
	}
	private void remove(int i,int j,int value,char[][] board)
	{
		board[i][j] = '.';
		choice[0][i].remove(value);
		choice[1][j].remove(value);
		choice[2][(j/3)*3 +(i/3)].remove(value);
	}
	
	private Set<Integer> findSuitSet(int i, int j)
	{
		Set<Integer> rst = new HashSet<Integer>();
		for (int k = 1; k<=9;k++) 
		{
			if (suitAble(i,j,k)) rst.add(k);
		}
		return rst;
	}
	private boolean suitAble(int i,int j,int value)
	{
		if (choice[0][i].contains(value) 
				|| choice[1][j].contains(value)
				|| choice[2][(j/3)*3 +(i/3)].contains(value)) return false;
		return true;
	}
	private boolean solute(char[][] board, int left)
	{
		if (left == 0) return true;
		Set<Integer> cset = null;
		int min = 10;
		int x =0;
		int y =0;
		for (int i = 0; i< 9;i++)
		{
			for (int j = 0; j<9; j++)
			{
				if (board[i][j] == '.')
				{
					Set<Integer> tmp = findSuitSet(i, j);
					if (tmp.size() == 0) return false;
					if (tmp.size() < min)
					{
						min = tmp.size();
						cset = tmp;
						x = i;
						y = j;
					}
				}
			}
		}
		if (min > 4) return true;
		for (int value : cset)
		{
			
			add(x, y, value,board);
			if (solute(board,left-1)) return true;
			remove(x, y, value,board);
		}
		return false;
		
	}
    public boolean isValidSudoku(char[][] board) {
    	int i ,j, k = 0;
    	for (i = 0; i< 3; i++)
    	{
    		for (j =0; j<9; j++) 
    			choice[i][j] = new HashSet<Integer>();
    			
    	}
    	for (i = 0;i<9;i++)
    		for (j = 0 ;j< 9 ; j++)
    		{
    			if (board[i][j] == '.')
    			{
    				k ++ ;
    			}else
    			{
    				int tmp =  board[i][j] - '0';
    				if (!suitAble(i, j, tmp)) return false;
    				add(i,j,tmp,board);
    			}
    		}
    	return solute(board, k);
    }
}