package CombinationSum;

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
			int j = i;
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
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    	ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
    	Arrays.sort(candidates);
    	if (target ==  0)
    	{
    		rst.add(new ArrayList<Integer>());
    		return rst;
    	}
    	for (int i= 0 ; i < candidates.length &&  candidates[i] <= target; i++)
    	{
    		ArrayList<Integer> tmp = new ArrayList<Integer>();
    		search(i,target,candidates,tmp,rst);
    		while (i < candidates.length - 1 && candidates[i + 1] == candidates[i]) i++;
    	}
    	return rst;
    }
}