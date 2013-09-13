class Solution {
public:
    bool isPalindrome(int x) {
        long long other =0;
		int k = x;
		while (k >0 ){
			other = other * 10 + k % 10;
			k = k /10;
		}
		return other ==  x;
    }
};