package q22_GenerateParentheses;

import java.util.ArrayList;

public class Solution {
	
	 private void fill(int last, int count,int index,char[] buf , ArrayList<String> rst)
	 {
		 if (last == 0) 
		 {
			 while (count -- > 0)
			 {
				 buf[index ++] = ')';
			 }
			 rst.add( new String (buf));
			 return;
		 }
		 if (count > 0)
		 {
			 buf[index] = ')';
			 fill(last , count - 1, index + 1,buf,rst );
		 } 
		 buf[index] = '(';
		 fill(last-1, count + 1, index +1,buf,rst);
	 }
	
	
    public ArrayList<String> generateParenthesis(int n) {
    	ArrayList<String> rst =  new ArrayList<String>();
    	
    	char[] buf = new char[n*2];
    	if (n ==0) 
    	{
    		rst.add("");
    		return rst;
    	}
    	fill( n,0,0,buf, rst);
    	return rst;
    	
    }
}