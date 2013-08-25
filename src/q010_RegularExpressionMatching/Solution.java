package q010_RegularExpressionMatching;

public class Solution {
	
	Boolean[][] f = null;

	private boolean search(String s, String p, int u, int v) {
		if (f[u][v] != null)
			return f[u][v];
		if (v == p.length() && u < s.length()) {
			f[u][v] = false;
			return f[u][v];
		} else if (u == s.length() && v < p.length()) {
			if (v + 1 < p.length()) {
				if (p.charAt(v + 1) == '*') {
					f[u][v] = search(s, p, u, v + 2);
				} else {
					f[u][v] = false;
				}
				return f[u][v];
			} else {
				f[u][v] = false;
				return f[u][v];
			}
		} else {
			if (p.charAt(v) == '.' || p.charAt(v) == s.charAt(u)) {
				if (v + 1 < p.length() && p.charAt(v + 1) == '*') {
					if (search(s, p, u, v + 2)) {
						f[u][v] = true;
						return f[u][v];
					}
					if (u + 1 < s.length()
							&& (s.charAt(u + 1) == p.charAt(v) || p.charAt(v) == '.')) {
						if (search(s, p, u + 1, v)) {
							f[u][v] = true;
							return f[u][v];
						}
					}
					f[u][v] = search(s, p, u + 1, v + 2);
					return f[u][v];
				} else {
					f[u][v] = search(s, p, u + 1, v + 1);
					return f[u][v];
				}
			} else {
				if (v + 1 < p.length() && p.charAt(v + 1) == '*') {
					f[u][v] = search(s, p, u, v + 2);
					return f[u][v];
				} else {
					f[u][v] = false;
					return f[u][v];
				}
			}

		}
	}

	public boolean isMatch(String s, String p) {
		if (s == null || p == null)
			return false;
		f = new Boolean[s.length() + 1][];
		for (int i = 0; i <= s.length(); i++) {
			f[i] = new Boolean[p.length() + 1];
			for (int j = 0; j <= p.length(); j++)
				f[i][j] = null;
		}
		f[s.length()][p.length()] = true;
		return search(s, p, 0, 0);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().isMatch("aa", "aa"));
	}
}