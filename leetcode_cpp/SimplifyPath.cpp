#include <string>
#include <sstream>
#include <vector>
using namespace std;
class Solution {
public:
    string simplifyPath(string path) {
        vector<string> patharr(1,"");
		if (path == "") return "/";
		int i =0;
		while (i < path.length()){
			if  (path[i] == '/') i++;
			else {
				int j = i;
				while (j <path.length() && path[j] != '/') j++;
				string ele =  path.substr(i,j-i);
				if (ele == "..") {
					if (patharr.size() >1) patharr.pop_back();
				}else if (ele != "."){
					patharr.push_back(ele);
				}
				i = j;
			}
		}
		string rst;
		stringstream ss ;
		for (int i =1;i<patharr.size(); i++){
			ss << "/";
			ss << patharr[i];
		}
		ss >> rst;
		if (rst == "") return "/";
		return rst;
    }
};