#include<vector>
using namespace std;
class Solution {
public:
    char *strStr(char *haystack, char *needle) {
       vector<int> next ;
	   next.push_back(-1);
	   int len=strlen(needle);
		if (len == 0) return haystack;
	   int j = -1;
	   for (int i = 1; needle[i] !='\0';i++){
		   while (j != -1 && needle[j+1]!= needle[i] ) j = next[j];
		   if (needle[j+1] == needle[i]) {
			   next.push_back(j+1);
				j++;
		   }
		   else next.push_back(j);
	   }
		j = -1;
		for (int i = 0; haystack[i] != '\0'; i++){
			while (j != -1 && haystack[i] != needle[j+1])  j = next[j];
			if (haystack[i] == needle[j+1]) {
				j++;
				if (needle[j+1] == '\0'){
					return haystack + i -len+1;
				}
			}
		}
		return NULL;
	}
};
