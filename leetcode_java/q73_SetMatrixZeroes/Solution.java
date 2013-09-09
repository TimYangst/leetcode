package q73_SetMatrixZeroes;

public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) return ;
    	if (matrix[0].length == 0) return ;
    	
    	int h=-1,l=-1;
    	for (int i = 0; i < matrix.length ; i++)
    		for (int j = 0 ;j < matrix[0].length; j++)
    		{
    			if (matrix[i][j] == 0)
    			{
    				if (h == -1)
    				{
    					h= i;
    					l =j;
    				}else 
    				{
    					matrix[h][j] = 0;
    					matrix[i][l] = 0;
    				}
    			}
    		}
    	if (h == -1) return;
    	for (int i = 0; i < matrix.length; i++ )
    	{
    		if (i != h)
                if (matrix[i][l] == 0)
        		{
        			for (int j = 0 ; j < matrix[0].length; j ++) 
        				matrix[i][j] = 0;
        				
        		}
    	}
    	for (int j = 0; j < matrix[0].length; j++)
    	{
            if( j!=l )
    		if (matrix[h][j] == 0)
    		{
    			for (int i =0; i< matrix.length;i++)
    			{
    				matrix[i][j] = 0 ;
    			}
    		}
    	}
        for (int j = 0 ; j < matrix[0].length; j ++) 
            matrix[h][j] = 0;
        for (int i =0; i< matrix.length;i++)
    		matrix[i][l] = 0 ;
    	
    }
    
}