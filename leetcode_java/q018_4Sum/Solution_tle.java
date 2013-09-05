package q018_4Sum;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_tle {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		for (int i = 0; i < num.length - 3; i++) {
			for (int j = i + 1; j < num.length - 2; j++) {
				int u = num.length - 1;
				for (int k = j + 1; k < u; k++) {
					while (u > k && num[i] + num[j] + num[k] + num[u] >= target)
						u--;
					if (u + 1 < num.length
							&& num[i] + num[j] + num[k] + num[u + 1] == target) {
						ArrayList<Integer> ele = new ArrayList<Integer>();
						ele.add(num[i]);
						ele.add(num[j]);
						ele.add(num[k]);
						ele.add(num[u + 1]);
						rst.add(ele);
					}
					while (k + 1 < u && num[k] == num[k + 1])
						k++;
				}
				while (j + 1 < num.length - 2 && num[j] == num[j + 1])
					j++;
			}
			while (i + 1 < num.length - 3 && num[i + 1] == num[i])
				i++;
		}
		return rst;
	}
}