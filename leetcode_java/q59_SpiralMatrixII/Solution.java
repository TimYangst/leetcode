package q59_SpiralMatrixII;

public class Solution {
	  public int[][] generateMatrix(int n) {
		  int[][] rst = null;
		  if (n ==0){rst = new int[0][]; return rst;};
		  if (n ==1){rst = new int[1][]; rst[0]= new int[1]; rst[0][0] = 1; return rst;}
		  if (n > 1) {
			  rst = new int[n][];
			  for (int i =0 ;i<n;i++) rst[i] = new int[n];
			  int l=0,r=n-1,u=0,d=n-1;
			  int k =1;
			  while (l < r)
			  {
				  for (int j = l; j < r; j++) rst[u][j] = k++;
				  for (int i = u; i < d; i++) rst[i][r] = k++;
				  for (int j = r; j > l; j--) rst[d][j] = k++;
				  for (int i = d; i > u; i--) rst[i][l] = k++;
				  l ++ ; r--;
				  u ++ ; d--;
			  }
			  if (l==r) rst[u][l] = k++;
		  }
		  return rst;
	  }
}
