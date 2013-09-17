package IntegerToRoman;

public class Solution {
    public String intToRoman(int num) {
    	String[] digits =  new String[] {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    	String[] tens =  new String[] {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    	String[] hundreds = new String[] {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    	
    	StringBuffer sb = new StringBuffer();
    	int thousands =  num /1000;
    	for (int  i= 0; i<thousands ;i++)  sb.append('M');
    	num = num % 1000;
    	sb.append(hundreds[num /100]);
    	num = num % 100;;
    	sb.append(tens[num/10]);
    	num = num %10;
    	sb.append(digits[num]);
    	return sb.toString();        
    }
}