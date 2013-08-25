package q65_ValidNumber;

public class Solution {
	boolean isTag(char c) {
		return c == '-' || c == '+';
	}

	boolean isDigit(char c) {
		return '0' <= c && c <= '9';
	}

	boolean isDot(char c) {
		return c == '.';
	}

	boolean isExp(char c) {
		return c == 'e' || c == 'E';
	}

	public boolean isNumber(String s) {
		if (s == null || "".equals(s.trim()))
			return false;
		s = s.trim();
		char[] arr = s.toCharArray();

		int i = 0;
		try {
			if (isTag(arr[i]))
				i++;
			if (isDigit(arr[i]) || isDot(arr[i])) {
				if (isDigit(arr[i])) {
					while (i < arr.length && isDigit(arr[i]))
						i++;
					if (i == arr.length)
						return true;
					if (isDot(arr[i])) {
						i++;
						while (i < arr.length && isDigit(arr[i]))
							i++;
						if (i == arr.length)
							return true;
					}
					if (!isExp(arr[i]))
						return false;
					i++;
				} else {
					i++;
					if (!isDigit(arr[i]))
						return false;
					while (i < arr.length && isDigit(arr[i]))
						i++;
					if (i == arr.length)
						return true;
					if (!isExp(arr[i]))
						return false;
					i++;
				}
				if (isTag(arr[i]))
					i++;
				if (isDigit(arr[i]))
				{
					while (i<arr.length && isDigit(arr[i]))
						i++;
				}else return false;
				if (i == arr.length)
					return true;
			} else
				return false;
		} catch (Exception e) {
			return false;
		}
		return false;
	}
}