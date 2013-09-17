package SearchforaRange;

public class Solution {

	private int search(int[] A, int b, int e, int target, boolean front) {
		if (b >= e)
			return -1;
		if (b + 1 == e) {
			if (A[b] == target)
				return b;
			return -1;
		}
		int mid = (b + e) / 2;
		if (A[mid] == target) {
			int k;
			if (front) {
				k = search(A, b, mid, target, front);
			} else {
				k = search(A, mid + 1, e, target, front);
			}
			if (k == -1)
				return mid;
			return k;

		}
		if (A[mid] > target)
			return search(A, b, mid, target, front);
		else
			return search(A, mid + 1, e, target, front);

	}

	public int[] searchRange(int[] A, int target) {
		int b = search(A, 0, A.length, target, true);
		if (b == -1)
			return new int[] { -1, -1 };
		int e = search(A, 0, A.length, target, false);
		return new int[] { b, e };

	}
}