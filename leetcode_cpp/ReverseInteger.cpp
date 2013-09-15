class Solution {
public:
    int reverse(int x) {
        int rst = 0;
		while (x !=0){
			rst = rst * 10 + x % 10;
			x = x /10;
		} 
		return rst;
    }
};