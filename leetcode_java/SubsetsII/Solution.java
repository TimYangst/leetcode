package SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
    	ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
    	if (num.length == 0)
    	{
    		rst .add(new ArrayList<Integer>());
    		return rst;
    	}
   		Arrays.sort(num);
   		int[] point = new int[num.length];
   		int[] count = new int[num.length];
   		int type = 0;
   		int i =0;
   		while (i < num.length)
   		{
   			int j =i;
   			point[type] = i;
   			while (j < num.length && num[j] == num[i]) j++;
   			count[type] = j- i;
   			type ++;
   			i = j;
   		}
   		int  tot =1;
   		for (i =0;i<type;i++)
   		{
   			tot *= (count[i] +1); 
   		}
   		
   		for (i = 0 ; i<tot ;i++)
   		{
   			int j = i;
   			ArrayList<Integer> ele = new ArrayList<Integer>();
   			for (int k = 0;k<type;k++)
   			{
   				for (int u = 0;u< j % (count[k] +1) ; u++)
   				{
   					ele.add(num[point[k]]);
   				}
   				j = j / (count[k] + 1);
   			}
   			rst.add(ele);
   		}
   		return rst;
    }
}