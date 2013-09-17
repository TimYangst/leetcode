package MultiplyStrings;

public class Solution {
	
	private String doMultiply(String n1, String n2)
	{
		int[] a1 = new int[n1.length()];
		int[] a2 = new int[n2.length()];
		for (int i =0;i< n1.length(); i++)
		{
			a1[i] = n1.charAt(n1.length() - i -1) - '0';
		}
		for (int i = 0; i< n2.length(); i++){
			a2[i] = n2.charAt(n2.length() - i -1) - '0';
		}
		int[] rst = new int[a1.length + a2.length];
		for (int i=0;i<rst.length;i++) rst[i] = 0;
		
		for (int i =0; i < a1.length ;i++)
		{
			for (int j=0; j<a2.length; j++)
			{
				rst[i+j] +=  a1[i] * a2[j];
				rst[i+j +1] += rst[i+j] / 10;
				rst[i+j] %= 10;
			}
		}
			
		StringBuffer sb = new StringBuffer();
		int k = a1.length + a2.length -1;
		while (rst[k] == 0) k--;
		while (k >=0) 
		{
			sb.append(rst[k]);
			k--;
		}
		return sb.toString();
	}
    public String multiply(String num1, String num2) {
    	if (num1 ==null || num2 ==null ) return null;
    	if ("".equals(num1.trim()) || "".equals(num2.trim())) return "";
    	if ("0".equals(num1) || "0".equals(num2)) return "0";
    	return doMultiply(num1,num2);
    }
    public static void main(String[] args) {
		new Solution().multiply("1", "1");
	}
}