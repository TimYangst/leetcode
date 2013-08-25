package q44_WildcardMatching;

public class Solution_tle2 {
    public boolean isMatch(String s, String p) {
    	if (s == null || p == null) return false;
    	if (s.length() == 0 && p.length() == 0) return true;
    	
    	char[] arrS = s.toCharArray();
    	char[] arrP = p.toCharArray();
    	
    	boolean last[] = null;
    	boolean current[] = new boolean[arrP.length+1];
    	
    	current[0] =  true;
    	for (int j = 1; j <= arrP.length; j++) 
    		current[j]= current[j-1] && arrP[j-1] == '*';
    	
    	for (int i = 1; i <= arrS.length; i++) 
    	{
    		last = current;
    		current = new boolean[arrP.length+1];
    		current[0] = false;
    		for (int j =1; j<= arrP.length; j++ )
    		{
    			current[j] = false; 
    			current[j] = last[j-1] && (arrS[i-1] == arrP[j-1] || arrP[j-1] == '?');
    			current[j] = current[j] || current[j-1] && arrP[j-1] == '*';
    			current[j] = current[j] || last[j] && arrP[j-1] == '*';
    		}
    	}
        return current[arrP.length];
    }
}