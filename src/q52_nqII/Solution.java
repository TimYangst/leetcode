package q52_nqII;

public class Solution {
    boolean[] line, leftup, rightup;
	int[] solution;
	int n;
	public int totalNQueens(int n) {
		int rst = 0;
		line = new boolean[n];
		leftup = new boolean[n + n - 1];
		rightup = new boolean[n + n - 1];
		this.n = n;
		if (n == 1)  return 1;
		if (n < 4) return 0;
		for (int i = 0; i < n; i++) {
			line[i] = true;
		}
		for (int i = 0; i < n + n - 1; i++) {
			leftup[i] = true;
			rightup[i] = true;
		}
		solution = new int[n];
		int k = 0;
		int i = 0;
		while (true) {
			if (i == n || k == n) {
				if (k == 0)
					break;
				if (k == n) {
					rst ++;
				}
				k--;
				line[solution[k]] = true;
				leftup[k + solution[k]] = true;
				rightup[k - solution[k] + n - 1] = true;
				i = solution[k];
			} else {
				if (line[i] && leftup[i + k] && rightup[k - i + n - 1]) {
					solution[k] = i;
					line[solution[k]] = false;
					leftup[k + solution[k]] = false;
					rightup[k - solution[k] + n - 1] = false;
					k++;
					i = 0;
					continue;
				}
			}
			i++;
		}
		return rst;
	}
}