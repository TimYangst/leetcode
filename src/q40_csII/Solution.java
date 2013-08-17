package q40_csII;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	
	private void search(int i,int target,int[] cand, ArrayList<Integer> tmp,ArrayList<ArrayList<Integer>> rst)
	{
		if (cand[i] > target) return;
		if (cand[i] == target) 
		{
			ArrayList<Integer> element = new ArrayList<Integer>();
			element.addAll(tmp);
			element.add(cand[i]);
			rst.add(element);
			return; 
		} 
		if (target -cand[i] >= cand[i])
		{
			tmp.add(cand[i]);
			target -= cand[i];
			int j = i +1;
			while (j < cand.length)
			{
				search(j,target,cand,tmp,rst);
				while (j< cand.length -1 && cand[j+1] == cand[j]) j++;
				j++;
			}
			target += cand[i];
			tmp.remove(tmp.size() -1);
		}
	}
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
    	ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
    	Arrays.sort(num);
    	if (target ==  0)
    	{
    		rst.add(new ArrayList<Integer>());
    		return rst;
    	}
    	for (int i= 0 ; i < num.length &&  num[i] <= target; i++)
    	{
    		ArrayList<Integer> tmp = new ArrayList<Integer>();
    		search(i,target,num,tmp,rst);
    		while (i < num.length - 1 && num[i + 1] == num[i]) i++;
    	}
    	return rst;
    }
}