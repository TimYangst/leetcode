package Sqrtx;

public class Solution {
	private int find(int x, int b ,int e)
	{
		if (b >= e-1) return b;
		int mid = (b+e)/2;
		int k =  x / mid;
		if (mid ==  k) return mid;
		if(mid <k)
		{
			if (x / (mid +1) < (mid + 1 )) return mid;
			return find(x, mid + 1,e);
		}
		return find(x,b,mid);
	}
	
    public int sqrt(int x) {
    	if (x <= 1) return x; 
        return find(x,1,x);
    }
}