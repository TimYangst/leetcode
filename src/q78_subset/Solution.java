package q78_subset;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    	Arrays.sort(S);
        ArrayList<ArrayList<Integer>> rst =  new ArrayList<ArrayList<Integer>>();
        int tot = 1 << S.length;
        for (int i =0;i< tot;i++)
        {
        	ArrayList<Integer> ele = new ArrayList<Integer>(); 
        	for (int j =0;j<S.length;j++)
        	{
        		if ((( 1 << j ) & i) != 0) 
        		{
        			ele.add(S[j]);
        		}
         	}
        	rst.add(ele);
        }
        return rst;
    }
}