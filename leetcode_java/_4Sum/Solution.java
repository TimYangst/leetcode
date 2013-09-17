package _4Sum;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	
	class Element
	{
		int sum = 0;
		int index1;
		int index2;
	}
	 public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) 
	 {
		 ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		 Arrays.sort(num);
		 ArrayList<Element> list =  new ArrayList<Element>();
		 int i =0;
		 int j =0;
		 while (i<num.length - 2)
		 {
			 j = i + 1;
			 while (j < num.length -1)
			 {
				 Element ele = new Element();
				 ele.index1 =  i;
				 ele.index2 =  j;
				 ele.sum = num[i] + num[j];
				 list.add(ele);
				 if (j < num.length -2 && num[j+1] == num[j])
				 {
					 while (j < num.length -2 && num[j+1] == num[j])
					 {
						 j++;
					 }
					 if (j >= i + 3 && num[i] * 4 == target)
					 {
						 ArrayList<Integer> newEle = new ArrayList<Integer>();
						 newEle.add(num[i]);
						 newEle.add(num[i]);
						 newEle.add(num[i]);
						 newEle.add(num[i]);
						 rst.add(newEle);
					 }
					 i = j;
				 }
				 j++;
			 }
		 }
		
		 Element[] elearray = new Element[list.size()];
		 elearray = list.toArray(elearray);
		 Arrays.sort(elearray);
		 return rst;
	 }
	
}
