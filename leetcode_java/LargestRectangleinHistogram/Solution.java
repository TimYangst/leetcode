package LargestRectangleinHistogram;

public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height.length == 0) return 0;
        int max = 0;
        int[] f,g;
        f= new int[height.length];
        g= new int[height.length];
        f[0] = -1;
        g[height.length-1] = height.length;
        for (int i = 1;i< height.length;i++)
        {
        	int j = i-1;
        	while ( j >= 0 && height[j] >= height[i])  j = f[j];
        	f[i] = j;
        }
        for (int i = height.length -2; i >= 0; i--)
        {
        	int k = i+1;
        	while ( k < height.length && height[k] >= height[i]) k =g[k];
        	g[i] = k;
        }
        for (int i =0 ; i< height.length;i++)
        {
        	if ((g[i] - f[i] -1) * height[i] > max) max =(g[i] - f[i] -1) * height[i]; 
        }
       return max;
    }
}
