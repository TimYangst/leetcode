package q71_SimplifyPath;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
    	if (path == null) return path;
    	if ("".equals(path.trim())) return "";
    	Stack<String> paths = new Stack<String>();
    	String[] strs = path.split("/");
    	for (String str : strs)
    	{
    		if (str.equals(".."))
    		{
    			if (paths.size() >0) paths.pop();
    		}
    		else if (str.equals("") || str.equals(".")) continue;
    		else paths.push(str);
    	}
    	StringBuffer sb = new StringBuffer();
    	if (paths.size() == 0) return "/";
    	
    	for (Object str :  paths.toArray())
    	{
    		sb.append("/");
    		sb.append((String) str);
    	}
    	return sb.toString();
    }
}
