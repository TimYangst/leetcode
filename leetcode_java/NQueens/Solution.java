package NQueens;

import java.util.ArrayList;

public class Solution {

	private void addToRst() {
		String[] ele = new String[n];
		for (int i = 0; i < n; i++) {
			char[] lines = new char[n];
			for (int j = 0; j < n; j++) {
				lines[j] = '.';
				if (j == solution[i])
					lines[j] = 'Q';
			}
			ele[i] = new String(lines);
		}
		rst.add(ele);
	}

	boolean[] line, leftup, rightup;
	int[] solution;
	int n;
	ArrayList<String[]> rst;

	public ArrayList<String[]> solveNQueens(int n) {
		rst = new ArrayList<String[]>();
		line = new boolean[n];
		leftup = new boolean[n + n - 1];
		rightup = new boolean[n + n - 1];
		this.n = n;
		if (n == 1) {
			String[] t = new String[1];
			t[0] = "Q";
			rst.add(t);
			return rst;
		}
		if (n < 4)
			return rst;
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
					addToRst();
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
	public static void main(String[] args) {
		new Solution().solveNQueens(8);
	}
}