package q93_RestoreIPAddresses;

import java.util.ArrayList;

public class Solution {
    
	private void search(int[] buf,String s,int index,ArrayList<String> rst)
	{
		int left = 4 - index;
		if (s.length() <left || s.length() > 3 * left) return;
		if (index == 3)
		{
			int vl = -1;
			try {
				vl =  Integer.valueOf(s);
			} catch (Exception e) {
				return;
			}
            if ( vl>0 && s.charAt(0) == '0') return;
            if ( vl ==0 && s.length() > 1) return ;
			if (0 <= vl && vl <= 255) buf[3] = vl;
            else return;
            
			StringBuffer sb = new StringBuffer("" + buf[0]);
			for (int i =1;i<4;i++) sb.append("." + buf[i]);
			rst.add(sb.toString());
			return;
		}
		int i = 1;
		while (i <4 && i <s.length())
		{
			int vl = -1;
    		try {
    			vl = Integer.valueOf(s.substring(0,i));
    		} catch (Exception e) {
				return ;
			}
    		if (0<= vl && vl <= 255)
    		{
    			buf[index] = vl;
    			search(buf,s.substring(i),index +1,rst);
    		}
    		if (vl ==0) break;
    		i++;
		}
	}
    public ArrayList<String> restoreIpAddresses(String s) {
	    
    	ArrayList<String>  rst = new ArrayList<String>();
    	
    	if (s == null || s.length() < 4 || s.length() > 12) return rst;
    	int[] buf = new int[4];
    	for (int i =1;i<4;i++)
    	{
    		
    		int vl = -1;
    		try {
    			vl = Integer.valueOf(s.substring(0,i));
    		} catch (Exception e) {
				return rst;
			}
    		if (0<= vl && vl <= 255)
    		{
    			buf[0] = vl;
    			search(buf,s.substring(i),1,rst);
    		}
    		if (vl == 0) break;
    	}
        return rst;
    }
}