package q77_c;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
    	int[] tmp = new int[k];
    	for (int i =0; i< k ;i++) tmp[i] = i + 1;
    	while (true)
    	{
    		ArrayList<Integer> ele = new ArrayList<Integer>();
    		for (int i : tmp) { ele.add(i); }
    		rst.add(ele);
    		int j =  tmp.length -1;
    		while (j >= 0 && tmp[j] == n - (tmp.length -j -1)) j--;
    		if (j < 0) break;
    		tmp[j] ++;
    		for (int i = j + 1; i < tmp.length; i++) tmp[i] = tmp[i-1] + 1;
    	}
        return rst;
    }
}