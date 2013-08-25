package q87_ScrambleString;

public class Solution_tle {
    public boolean isScramble(String s1, String s2) {
    	
    	if (s1 == null && s2 == null) return true;
    	if (s1 == null || s2 == null) return false;
    	if (s1.length() != s2.length()) return false;
    	if (s1.equals(s2)) return true;
    	if (s1.length() == 1) return false;
    	
    	for (int half =1; half<= s1.length() /2 ;half ++)
    	{
    		int other = s1.length() - half;
    		if (isScramble(s1.substring(0,half), s2.substring(0,half)) 
        			&& isScramble(s1.substring(half), s2.substring(half)))
        		return true;
        	if (isScramble(s1.substring(0,half), s2.substring(other))
        			&& isScramble(s1.substring(half), s2.substring(0,other)))
        		return true;
        	if (half != other)
        	{
        		if (isScramble(s1.substring(0,other), s2.substring(0,other))
        				&& isScramble(s1.substring(other), s2.substring(other))) 
        			return true;
        		if (isScramble(s1.substring(0,other), s2.substring(half))
        				&& isScramble(s1.substring(other),s2.substring(0,half))) 
        			return true;
        	}
    	}
    	    	
    	return false;
    }
}