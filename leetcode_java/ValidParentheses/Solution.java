package ValidParentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
    	int i;
    	Stack<Character> qtStack = new Stack<Character>();
    	for (i=0;i<s.length();i++)
    	{
    		Character c = s.charAt(i);
    		if (c == '(' || c == '[' || c == '{')
    		{
    			qtStack.push(c);
    		} else if (c == ')' || c == ']' || c =='}')  
    		{
    			if (qtStack.size() == 0)
    			{
    				return false;
    			}
    			if (c == ')' &&  qtStack.pop() != '(')
    			{
    				return false;
    			}
    			if (c == ']' && qtStack.pop() != '[')
    			{
    				return false;
    			}
    			if (c == '}' && qtStack.pop() != '{')
    			{
    				return false;
    			}
    		}
    	}
        return qtStack.size() == 0;
    }
}