package q62_up;

public class Solution {
    public int uniquePaths(int m, int n) {
    	int[][] f = null;
    	f = new int[m][];
    	for (int i = 0 ; i< m ; i++){
    		f[i] =  new int[n];
    	}
    	if ( m == 0 || n == 0) return 0;
    	for (int i =0; i<m;i++)
    		for (int j =  0 ; j<n; j++)
    		{
    			if (i == 0 || j == 0) f[i][j] = 1;
    			else {
    				f[i][j] = f[i-1][j]+f[i][j-1];
    			}
    		}	
        return f[m-1][n-1];
    }
}