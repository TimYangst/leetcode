package q55_JumpGame;

public class Solution {
    public boolean canJump(int[] A) {
    	int b =0;
    	int e =A[0] + 0;
    	while (b <= e && e < A.length -1)
    	{
    		if (b + A[b] > e) e = b + A[b] ;
    		b++;
    	}
    	if (e >= A.length-1) return true;
       return false;
    }
}