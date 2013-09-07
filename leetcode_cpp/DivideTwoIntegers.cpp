class Solution {
public:
    int divide(int dividend, int divisor) {
		if (dividend == 0) return dividend;
		bool diff = (dividend <0 && divisor >0) || (dividend >0 && divisor <0);
		if (dividend >0) dividend = -dividend;
		if (divisor > 0) divisor = - divisor;
		int rst = 0;
		while (dividend <= divisor){
			int k = 1;
			int j =  divisor;
			while (dividend - j <= j){
				j =  j<<1;
				k = k <<1;
			}
			dividend -= j;
			rst += k;
		}
		if (diff) return -rst;
		return rst;
    }
};