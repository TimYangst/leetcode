package q42_TrappingRainWater;

public class Solution {

	private int calc(int b, int e, int h, int[] A) {
		int rst = 0;
		for (int i = b + 1; i < e; i++) {
			rst += h - A[i];
		}
		return rst;
	}

	public int trap(int[] A) {

		if (A.length <= 2) return 0;
		
		int rst = 0;

		int i = 0;
		int hight = A[i];
		while (true) {
			int j = i + 1;
			while (j < A.length && A[j] < hight)
				j++;
			if (j < A.length)
				rst += calc(i, j, hight, A);
			else
				break;
			i = j;
			hight = A[j];
		}

		i = A.length - 1;
		hight = A[i];
		while (true) {
			int j = i - 1;
			while (j >= 0 && A[j] <= hight)
				j--;
			if (j >= 0)
				rst += calc(j, i, hight, A);
			else
				break;
			i = j;
			hight = A[j];
		}

		return rst;
	}
}