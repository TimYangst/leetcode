package q67_ab;

public class Solution {
    public String addBinary(String a, String b) {
    	char[] rst = new char[Math.max(a.length(), b.length()) +1];
    	for (int i=0; i<rst.length; i++) rst[i] = 0;
    	for (int i=0; i<a.length(); i++) rst[a.length() - i - 1] += a.charAt(i) - '0';   
    	for (int i=0; i<b.length(); i++) rst[b.length() - i - 1] += b.charAt(i) - '0';
    	for (int i=0; i<rst.length-1; i++) 
    	{
    		rst[i+1] += rst[i] /2;
    		rst[i] = (char) (rst[i] % 2);
    	}
    	StringBuffer sb =  new StringBuffer();
    	int j = rst.length -1;
    	while (j > 0 && rst[j] == 0) j--;
    	while (j >= 0)
    	{
    		sb.append((char)(rst[j]+'0'));
    		j--;
    	}
    	return sb.toString();
    }
}