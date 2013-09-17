package RomanToInteger;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
    	Map<Character, Integer> symbol = new HashMap<Character, Integer>();
    	int rst = 0;
    	symbol.put('I', 1);
    	symbol.put('V', 5); 
    	symbol.put('X', 10); 
    	symbol.put('L', 50); 
    	symbol.put('C', 100); 
    	symbol.put('D', 500);
    	symbol.put('M', 1000);
    	int sum = 0;
    	for (int i = 0;  i< s.length(); i++)
    	{
    		if ( i == 0 ) sum = symbol.get(s.charAt(i));
    		else if (symbol.get(s.charAt(i-1)) > symbol.get(s.charAt(i))) {
    			rst += sum;
    			sum = symbol.get(s.charAt(i));
    		} else if(symbol.get(s.charAt(i-1)) ==  symbol.get(s.charAt(i))) {
    			sum += symbol.get(s.charAt(i));
    		} else {
    			rst += symbol.get(s.charAt(i)) - sum;
    			sum = 0;
    		}
    	}
    	rst += sum;
    	return rst; 
    }
}