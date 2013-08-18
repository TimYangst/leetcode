package q85_mr;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
    	if (matrix.length == 0 || matrix[0].length == 0) return 0;
    	int[] arr= new int[matrix[0].length];
    	for (int j =0 ; j < matrix[0].length ;j++) arr[j]= matrix[0][j]-'0';
    	int i =0;
    	int max = 0;
    	while (i < matrix.length)
    	{
    		if (matrix[i].length == 1)
    		{
    			if (arr[0] > max)
    			{
    				max = arr[0];
    			}
    		}else{
	    		int[] f,g;
	    		f = new int[matrix[i].length];
	    		g = new int[matrix[i].length];
	    		f[0] = -1;
	    		g[matrix[i].length-1] = matrix[i].length;
	    		
	    		for (int j =1;j< matrix[i].length;j++)
	    		{
	    			int k = j-1;
	    			while (k >=0 && arr[k] >= arr[j]) k = f[k];
	    			f[j] = k;
	    		}
	    		for (int j= matrix[i].length -2;j >=0;j--)
	    		{
	    			int k = j+1;
	    			while (k<matrix[i].length && arr[k]>=arr[j]) k =g[k];
	    			g[j]= k;
	    		}
	    		for (int  j =0;j<matrix[i].length;j++)
	    		{
	    			if ((g[j] -f[j] -1)*arr[j] > max) max = (g[j] -f[j] -1)*arr[j];
	    		}
    		}
    		
    		i++;
    		if (i == matrix.length) break;
    		for (int j = 0;j<matrix[i].length;j++)
    		{
    			if (matrix[i][j] == '0') arr[j] =0;
    			else arr[j] ++;
    		}
    	}
    	return max;
    }
}
