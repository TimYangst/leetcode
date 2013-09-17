package WildcardMatching;

public class Solution {

		private boolean search(char[] s,char[] p, int i1,int i2)
		{
			if (i1 ==  s.length)
			{
				if (i2 == p.length) return true;
				if (p[i2] == '*') return search(s,p,i1,i2+1);
				return false;
			}
			if (i2 ==  p.length) return false;
			if (s[i1] == p[i2] || p[i2] == '?') return search(s,p,i1+1,i2+1);
			if (p[i2] == '*') return search(s,p,i1+1,i2) || search(s,p,i1,i2+1);
			return false;
			
		}
	    public boolean isMatch(String s, String p) {
	    	if (s == null || p == null) return false;
	    	return search(s.toCharArray(),p.toCharArray(),0,0);
	    }

}
