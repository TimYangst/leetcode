package MinimumPathSum;

public class Solution {
    public int minPathSum(int[][] grid) {
    	int[][] f;
    	if (grid.length == 0) return 0;
    	if (grid[0].length == 0) return 0;
    	
    	f =  new int[grid.length][];
    	for (int i = 0 ; i<  f.length; i++)
    	{
    		f[i] =  new int[grid[0].length];
    	}
    	for (int i = 0 ; i<  f.length; i++)
    		for (int  j =0 ;j < f[0].length; j++)
    		{
    			f[i][j] = grid[i][j];
    			if ( i == 0 && j == 0) continue;
    			int min =  Integer.MAX_VALUE;
    			if ( i > 0 && f[i-1][j] < min) min = f[i-1][j];
    			if ( j > 0 && f[i][j-1] < min) min = f[i][j-1];
    			f[i][j] += min;
    		}
        return f[f.length-1][f[0].length-1];
    }
}