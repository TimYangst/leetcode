package q28_ImplementstrStr;

public class Solution {
	
	private char get(String target,int index)
	{
		return target.charAt(index -1) ;
	}
    public String strStr(String haystack, String needle) {
         if (haystack == null || needle == null) return null;
         if (needle == "" ) return haystack;
        
         int[] pi = new int[needle.length() + 1];
         
         pi[0] = -1;
         pi[1] = 0;
         int i;
         int j = 0  ;
         
         for (i = 2; i <= needle.length(); i++)
         {
        	 while (j > 0 && get(needle,i) != get(needle,j + 1))
        	 {
        		 j = pi[j];
        	 }
        	 if (get(needle,i) == get(needle,j + 1)) j ++;
        	 pi[i] = j;
         }
         
         j = 1;
         int k = 0;
         for (i = 1;  i<= haystack.length(); i++)
         {
        	while (k > 0  && get(needle,k +1) != get(haystack, i )) 
        	{
        		k = pi[k];
        	}
        	if (get(needle,k+1) == get(haystack, i)) k ++;
        	if (k == needle.length())
        	{
        		return haystack.substring(i- needle.length());
        	}
         }
         return null;
    }
}