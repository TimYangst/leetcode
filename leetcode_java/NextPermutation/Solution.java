package NextPermutation;

public class Solution {
	public void nextPermutation(int[] num) {
		int j = -1;
		for (int i = 0; i < num.length - 1; i++) {
			if (num[i] < num[i + 1])
				j = i;
		}
		if (j == -1) {
			for (int i = 0; i < num.length / 2; i++) {
				int k = num[i];
				num[i] = num[num.length - i - 1];
				num[num.length - i - 1] = k;
			}
		} else {
			int k = j + 1;
			for (int i = j + 1; i < num.length; i++) {
				if (num[i] > num[j] && num[i] <= num[k])
					k = i;
			}
			int u = num[j];
			num[j] = num[k];
			num[k] = u;
			for (int i = j + 1; i <= (num.length + j) / 2; i++) {
				u = num[i];
				num[i] = num[num.length - 1 - (i - (j + 1))];
				num[num.length - 1 - (i - (j + 1))] = u;
			}
		}
	}
	
	public static void main(String[] args) {
		new Solution().nextPermutation(new int[]{1,3,2});
	}
}