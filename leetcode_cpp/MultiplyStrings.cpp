#include <string>
#include <vector>
using namespace std;
class Solution {
public:
    string multiply(string num1, string num2) {
		if (num1 == "0" || num2 == "0") return  "0";
		vector<int> rst(num1.size() + num2.size(),0);
		for (int i = 0; i < num1.length(); i++ ){
			for (int j = 0 ;j < num2.length(); j++){
				rst[i+j] += (num1[num1.length()-i-1] - '0') * (num2[num2.length()-j-1] - '0');
			}
		}
		for (int i = 1; i< rst.size(); i++){
			rst[i] += rst[i-1] / 10;
			rst[i-1] =  rst[i-1] % 10;
		}
		while (rst[rst.size()-1] == 0) rst.pop_back();
		string rstr("");
		for (int i = rst.size() -1; i>=0; i--) {
			rstr += '0' +rst[i];
		} 
		return rstr;
    }
};