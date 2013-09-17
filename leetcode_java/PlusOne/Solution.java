package PlusOne;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	public int[] plusOne(int[] digits) {
		int[] rst;
		if (digits.length == 0) {
			rst = new int[1];
			rst[0] = 1;
			return rst;
		}
		List<Integer> tmp = new LinkedList<Integer>();
		int j = 1;

		for (int i = digits.length - 1; i >= 0; i--) {
			int k = digits[i] + j;
			j = k / 10;
			k = k % 10;
			tmp.add(k);
		}
		if (j > 0)
			tmp.add(j);
		rst = new int[tmp.size()];
		int i = 0;
		for (Integer ele : tmp)
			rst[tmp.size() - (i++) -1] = ele;
		return rst;
	}
}