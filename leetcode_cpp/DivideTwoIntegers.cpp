class Solution {
public:
    int divide(int dividend, int divisor) {
    	if (dividend == 0) return dividend;
		bool diff = (dividend <0 && divisor >0) || (dividend >0 && divisor <0);
		if (dividend >0) dividend = -dividend;
		if (divisor > 0) divisor = - divisor;
		int rst = 0;
		int k = 1;
		int j =  divisor;
		while (dividend - j <= j){
			j = j <<1;
			k = k <<1;
		}
		while (dividend !=0 && k != 0){
			if (dividend <= j) {
				dividend -= j;
				rst += k;
			}
			j = j >> 1;
			k = k >> 1;
		}
		if (diff) return -rst;
		return rst;
    }
};