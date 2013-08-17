package q45_jgII;

public class Solution {
	public int jump(int[] A) {

		if (A.length <= 1)
			return 0;
		int[] f = new int[A.length];

		f[0] = 0;
		f[1] = A[0];
		int t = 1;
		int j = 0;

		while (f[t] < A.length - 1) {
			t++;
			f[t] = f[t - 1] + A[f[t - 1]];
			int i = j + 1;
			while (i <= f[t - 1] && f[t] < A.length - 1) {
				if (A[i] + i > f[t])
					f[t] = A[i] + i;
				i++;
			}
			j = i-1;
		}
		return t;
	}
}