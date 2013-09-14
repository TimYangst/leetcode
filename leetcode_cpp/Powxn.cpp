class Solution {
public:
    double pow(double x, int n) {
        if (n ==0) return 1;
		if (x == 0) return 0;
		double rst  = 1;
		double k = x;
		if (n < 0) k = 1/ k;
		while (n != 0){
			if  (n % 2 != 0) rst *= k;
			k = k * k;
			n = n /2;
		}
		return rst;
    }
};