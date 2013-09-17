package PermutationSequence;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	
    public String getPermutation(int n, int k) {
    	if (n == 0) return "";
    	if (n == 1) return "1";
    	char[] rst = new char[n];
    	int[] factorial = new int[n];
    	List<Integer> last = new LinkedList<Integer>();
    	last.add(1);
    	factorial[0] = 1;
    	for (int i =1;i<n;i++) {
    		factorial[i] =  i * factorial[i-1];
    		last.add(i+1);
    	}
    	factorial[0] = 0;
    	int rank =  k -1;
    	for (int i = 0 ; i < n - 1 ;i++)
    	{
    		int j = n - i -1;
    		int ele = rank / factorial[j];
    		rst[i] = (char) ('0' +last.get(ele));
    		last.remove(ele);
    		rank = rank - ele * factorial[j];
    	}
    	rst[n-1] =( char )('0' +last.get(0));
    	return new String(rst);
    }
    public static void main(String[] args)
    {
    	new Solution().getPermutation(2, 2);
    }
}