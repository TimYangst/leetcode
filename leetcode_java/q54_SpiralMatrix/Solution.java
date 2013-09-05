package q54_SpiralMatrix;

import java.util.ArrayList;

public class Solution {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> rst = new ArrayList<Integer>();
		if (matrix.length == 0)
			return rst;
		if (matrix[0].length == 0)
			return rst;
		int l = 0, d = 0, r = matrix.length - 1, u = matrix[0].length - 1;

		while (l < r && d < u) {
			for (int j = d; j < u; j++)
				rst.add(matrix[l][j]);
			for (int i = l; i < r; i++)
				rst.add(matrix[i][u]);
			for (int j = u; j > d; j--)
				rst.add(matrix[r][j]);
			for (int i = r; i > l; i--)
				rst.add(matrix[i][d]);
			l++;
			r--;
			d++;
			u--;
		}
		if (l > r || d > u)
			return rst;

		if (l < r) {
			for (int i = l; i <= r; i++)
				rst.add(matrix[i][d]);
		} else if (d <= u) {
			for (int j = d; j <= u; j++)
				rst.add(matrix[l][j]);
		}
		return rst;
	}
}