class Solution {
public:
    int lengthOfLastWord(const char *s) {
		int rst = 0;
		int i = 0;
		while (s[i] != '\0'){
			int t =  0;
			while (s[i] == ' ') i++;
			if (s[i] == '\0') return rst;
			while (s[i] != ' ' && s[i] !='\0') {
				t++;
				i++;
			}
			rst =  t;
		}
		return rst;
    }
};