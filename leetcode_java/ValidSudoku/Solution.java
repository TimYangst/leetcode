package ValidSudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
    	for (int i = 0; i < 9; i++)
    	{
    		Set<Character> set = new HashSet<Character>();
    		for (int j = 0 ;j < 9; j++) {
    			if (board[i][j] != '.') {
    				if (set.contains(board[i][j])) return false;
    				set.add(board[i][j]);
    			}
    		}
    	}
    	for (int j = 0 ;j < 9; j++) {
    		Set<Character> set = new HashSet<Character>();
    		for (int i = 0; i < 9; i++) {
    			if (board[i][j] != '.') {
    				if (set.contains(board[i][j])) return false;
    				set.add(board[i][j]);
    			}
    		}
    	}
    	for (int k = 0; k < 9; k ++)
    	{
    		Set<Character> set = new HashSet<Character>();
    		for (int u = 0 ; u < 9 ; u++)
    		{
    			int i =  (k / 3) * 3 + (u / 3);
    			int j =  (k % 3) * 3 + (u % 3);
    			if (board[i][j] != '.') {
    				if (set.contains(board[i][j])) return false;
    				set.add(board[i][j]);
    			}
     		}
    			
    	}
        return  true;
    }
}