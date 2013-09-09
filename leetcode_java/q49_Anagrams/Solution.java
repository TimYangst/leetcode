package q49_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

	private String getStandard(String a1) {
		char[] chars = a1.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> rst = new ArrayList<String>();
		Map<String, List<String>> classSet = new HashMap<String, List<String>>();

		for (int i = 0; i < strs.length; i++) {
			String standard = getStandard(strs[i]);
			List<String>  ele = classSet.get(standard);
			if (ele == null){
				ele = new LinkedList<String>();
				ele.add(strs[i]);
				classSet.put(standard, ele);
			}else ele.add(strs[i]);				
		}

		for (List<String> list : classSet.values()) {
			if (list.size() > 1) {
				for (String str : list)
					rst.add(str);
			}
		}
		return rst;
	}
}
