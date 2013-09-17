package RotateImage;

public class Solution {
    public void rotate(int[][] matrix) {
    	if (matrix.length <= 1) return;
    	int l = matrix.length - 1;
    	int h = (matrix.length + 1) /2;
    	int w =  matrix.length /2;
    	for (int i =0 ;i < h; i++)
    		for (int j = 0;j <w;j++)
    		{
    			int tmp = matrix[i][j];
    			matrix[i][j] =  matrix[l -j][i];
    			matrix[l-j][i] = matrix[l-i][l-j];
    			matrix[l-i][l-j] = matrix[j][l-i];
    			matrix[j][l-i]= tmp;
    		}
    }
}