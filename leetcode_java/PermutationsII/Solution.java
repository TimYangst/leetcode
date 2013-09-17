package PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	private void addToResult(int[] num, ArrayList<ArrayList<Integer>> rst) {
		ArrayList<Integer> ele = new ArrayList<Integer>();
		for (int item : num) {
			ele.add(item);
		}
		rst.add(ele);
	}

	private int findLastOrderPair(int[] num) {
		int i = 0;
		int rst = -1;
		while (i < num.length - 1) {
			if (num[i] < num[i + 1])
				rst = i;
			i++;
		}
		return rst;
	}

	private int findNextLarger(int[] num, int index) {
		int j = index + 1;
		int k = j;
		while (j < num.length) {
			if (num[j] > num[index] && num[j] <= num[k])
				k = j;
			j++;
		}
		return k;
	}

	private void swap(int[] num, int i, int j) {
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}

	private void reverse(int[] num, int b, int e) {
		int mid = (b + e) / 2;
		for (int i = b; i <= mid; i++) {
			swap(num, i, e - i + b);
		}
	}

	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		while (true) {
			addToResult(num, rst);
			int index = findLastOrderPair(num);
			if (index == -1)
				break;
			int k = findNextLarger(num, index);
			swap(num, index, k);
			reverse(num, index + 1, num.length - 1);
		}
		return rst;
	}
}