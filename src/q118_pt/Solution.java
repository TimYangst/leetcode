package q118_pt;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0) return rst;
        ArrayList<Integer> ele = new ArrayList<Integer>();
        ele.add(1);
        rst.add(ele);
        for (int i =2;i<= numRows;i++)
        {
        	ArrayList<Integer> last = ele; 
        	ele =  new ArrayList<Integer>();
        	ele.add(1);
        	for (int j = 1; j < i -1;j++)
        		ele.add(last.get(j-1) + last.get(j));
        	ele.add(1);
        	rst.add(ele);
        }
        return rst;
    }
}