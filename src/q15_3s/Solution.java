package q15_3s;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		int i, j, k;
		for (i = 0; i < num.length - 2; i++) {
			if (i > 0 && num[i] == num[i - 1])
				continue;

			for (j = i + 1; j < num.length - 1; j++) {

				if (j > i + 1 && num[j] == num[j - 1])
					continue;
				for (k = j + 1; k < num.length; k++) {
					if (k > j + 1 && num[k] == num[k - 1])
						continue;

					if (num[i] + num[j] + num[k] == 0) {
						ArrayList<Integer> newEle = new ArrayList<Integer>(3);
						newEle.add(num[i]);
						newEle.add(num[j]);
						newEle.add(num[k]);
						rst.add(newEle);
					}
				}

			}
		}
		return rst;
	}

	public static void main(String[] args) {

		new Solution().threeSum(new int[] {-7,-10,-1,3,0,-7,-9,-1,10,8,-6,4,14,-8,9,-15,0,-4,-5,9,11,3,-5,-8,2,-6,-14,7,-14,10,5,-6,7,11,4,-7,11,11,7,7,-4,-14,-12,-13,-14,4,-13,1,-15,-2,-12,11,-14,-2,10,3,-1,11,-5,1,-2,7,2,-10,-5,-8,-10,14,10,13,-2,-9,6,-7,-7,7,12,-5,-14,4,0,-11,-8,2,-6,-13,12,0,5,-15,8,-12,-1,-4,-15,2,-5,-9,-7,12,11,6,10,-6,14,-12,9,3,-10,10,-8,-2,6,-9,7,7,-7,4,-8,5,-4,8,0,3,11,0,-10,-9});
	}
}