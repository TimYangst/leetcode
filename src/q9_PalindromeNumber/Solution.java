package q9_PalindromeNumber;

public class Solution {
	private int revert(int x, int t)
	{
		
		if (x < 10) return  t * 10 + x;
		return revert(x / 10, t * 10 + x % 10);
		
	}
	
    public boolean isPalindrome(int x) {
    	if (x < 0) return false;
    	if (x <10) return true;
    	
        return x == revert(x, 0);
    }
    public static void main(String[] args) {
		System.out.println(new Solution().isPalindrome(1126446211));
	}
}