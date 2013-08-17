package q58_lolw;

public class Solution {
    public int lengthOfLastWord(String s) {
    	if (s == null) return 0;
    	int j = s.length() -1;
    	while (j>=0  && s.charAt(j) == ' ') j --;
    	if (j == -1) return 0;
    	int i = j;
    	while (i >= 0 && s.charAt(i) != ' ') i --;
    	return j -i;
    }
}