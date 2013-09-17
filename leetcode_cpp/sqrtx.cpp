class Solution {
public:
    int sqrt(int x) {
		if (x <= 1) return x;
		int b = 1, e = x /2;
		while (b < e) {
			if (b == e) return b;
			int mid = b + (e -b) /2;
			if (x / mid >= mid  && x / (mid +1) < mid + 1 ) return mid;
			if (x / mid > mid) b = mid +1;
			else e = mid -1;
		}
		return b;
    }
};