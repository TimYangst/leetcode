/*
 * Create date 2013-7-8
 *
 * @author YangTing
 *
 */


package TwoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
    	if (numbers ==  null || numbers.length  ==  0) return null;
    	int[] res = new int[2];
    	
    	if (numbers.length == 1) {
    		if (numbers[0] + numbers[0] ==  target) {
    			res[0]= 1; res[1]= 1;
    		}  else {
    			return null;
    		}
    	} 
    	Map<Integer,Integer> numMap = new HashMap<Integer,Integer>();
    	for (int i =0 ;i< numbers.length;i++)
    	{
    		numMap.put(numbers[i], i+1);
    	}
    	for (int i=0; i < numbers.length  ; i++)
    	{
    		int k =  target- numbers[i];
    		if (numMap.get(k)!= null)
    		{
    			int j =  numMap.get(k);
    			res[0]=i+1;
    			res[1]=j;
    			break;
    		}
    	}
    	return res;
        
    }
    
    public static void main(String[] args) {
		Solution sl = new Solution();
		int[] r = sl.twoSum(new int[]{2,1,9,4,4,56,90,3}, 8);
		System.out.println(r[0]+" "+r[1]);
	}
}