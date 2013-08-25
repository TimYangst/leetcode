package q63_UniquePathsII;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int[][] f= null;
    	if (obstacleGrid.length == 0) return 0;
    	if (obstacleGrid[0].length == 0) return 0;
    	if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length -1][obstacleGrid[0].length -1] == 1) return 0;
    	
    	
    	f = new int[obstacleGrid.length][];
    	for (int i = 0 ;i < f.length;i++)
    	{
    		f[i] = new int[obstacleGrid[0].length];
    	}
    	f[0][0] = 1;
    	for (int i = 0 ;i < f.length; i++)
    		for (int j = 0; j < f[0].length;j++)
    		{
    			if (i ==0 && j==0) continue;
    			f[i][j] = 0;
    			if (obstacleGrid[i][j] == 1)continue;
    			if (i > 0) f[i][j] +=f[i-1][j];
    			if (j > 0) f[i][j] +=f[i][j-1];
    		}
        return f[f.length -1][f[0].length-1];
    }
}