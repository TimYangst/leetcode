package q131_pp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> rst = new ArrayList<ArrayList<String>>();
        if (s== null || s.length() == 0) return rst;
        Boolean[][] f = new Boolean[s.length()][];
        for (int i =0 ;i<s.length();i++)
        {
            f[i] = new Boolean[s.length()];
            f[i][i] =  true;
            if (i < s.length() -1) f[i][i+1]  = (s.charAt(i) == s.charAt(i+1));
        }
        
        for (int j = 2; j < s.length();j++) 
        	for (int  i = 0 ;i < s.length()-j; i++)
        	{
        		if (s.charAt(i) == s.charAt(i+j)) f[i][i+j] = f[i+1][i+j-1];
        		else f[i][i+j] = false;
        	}
        search(s,0,new LinkedList<String>(),rst,f);
        return rst;
    }

	private void search(String s, int index, List<String> list,
			ArrayList<ArrayList<String>> rst,Boolean[][] f) {
		if (index == s.length()) {
			ArrayList<String> ele = new ArrayList<String>();
			ele.addAll(list);
			rst.add(ele);
			return;
		}
		for (int j = index;j < s.length();j++)
		{
			if (f[index][j])
			{
				list.add(s.substring(index, j+1));
				search(s,j+1,list,rst,f);
				list.remove(list.size() -1);
			}
		}
		
	}
}
