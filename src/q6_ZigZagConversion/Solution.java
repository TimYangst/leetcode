package q6_ZigZagConversion;

public class Solution {
	public String convert(String s, int nRows) {
		if (s == null || "".equals(s) || nRows == 1)
			return s;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < nRows; i++) {
			int j = i;
			boolean odd = false;
			while (j < s.length()) {
				sb.append(s.charAt(j));

				if (i == 0 || i == nRows - 1) {
					j += nRows * 2 - 2;
				} else {

					if (!odd) {
						j += (nRows - (i + 1)) * 2;
					} else {
						j += i + i;
					}
					odd = !(odd);
				}
			}
		}
		return sb.toString();
	}

}