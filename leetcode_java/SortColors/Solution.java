package SortColors;

public class Solution {
    public void sortColors(int[] A) {
       int[] count = new int[3];
       count[0]=0;count[1]=0;count[2]=0;
       for (int i = 0; i< A.length;i++) count[A[i]]++;
       int k =0;
       for (int i=0;i<count.length;i++)
    	   for (int j=0; j<count[i]; j++) A[k++] = i;
        
    }
}