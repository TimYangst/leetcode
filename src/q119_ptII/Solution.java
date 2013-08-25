package q119_ptII;

import java.util.ArrayList;

public class Solution {
    
	int gcd(int a, int b)
	{
		if (a < b) return gcd(b,a);
		if (a % b == 0) return b;
		return gcd(b,a %b);
	}
    public ArrayList<Integer> getRow(int rowIndex) {
    	ArrayList<Integer> rst =  new ArrayList<Integer>();
    	rowIndex ++;
    	if (rowIndex == 0) return rst;
    	rst.add(1);
    	if (rowIndex == 1) return rst;
    	int b =1; 
    	for (int k = 1 ; k < rowIndex -1; k++) 
    	{	
    		int u = k;
    		int v = rowIndex  - k;
    		int g1 = gcd(b ,u);  		
    		b = b /g1;
    		u = u /g1;
    		v = v / u;
    		b= b * v;
    		rst.add(b);
    	}
    	rst.add(1);
    	return rst;
    }
}