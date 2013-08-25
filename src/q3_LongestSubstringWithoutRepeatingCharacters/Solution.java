package q3_LongestSubstringWithoutRepeatingCharacters;

import java.util.*;

public class Solution {
	public int lengthOfLongestSubstring(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null)
			return 0;
		int length = s.length();
		if (length <= 1) {
			return length;
		}
		int[] f = new int[length];
		f[0] = 1;
		int max = 1;
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		charMap.put(s.charAt(0), 0);
		for (int i = 1; i < length; i++) {
			if (charMap.get(s.charAt(i)) == null) {
				f[i] = f[i - 1] + 1;
			} else {
				int last = charMap.get(s.charAt(i));
				if (i - 1 - f[i - 1] > last) {
					f[i] = f[i - 1] + 1;
				} else {
					f[i] = i - last;
				}

			}
			charMap.put(s.charAt(i), i);
			if (f[i] > max)
				max = f[i];
		}
		return max;
	}
}