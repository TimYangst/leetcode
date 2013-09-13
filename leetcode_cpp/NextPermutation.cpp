#include <vector>
using namespace std;
class Solution {
public:
    void nextPermutation(vector<int> &num) {
		int j=-1;
		for (int i = 0 ;i < num.size() - 1; i++)
			if (num[i]<num[i+1]) j = i;
		if (j == -1) { 
			reverse(num.begin(),num.end());
			return;
		}
		int k = j + 1;
		for  (int  i = j +1; i  <num.size(); i++ )
			if  (num[i] > num[j]  && num[i] <= num[k])  k = i;
		swap(num[j],num[k]);
		for (int i = j+1;i <= (j+1+num.size()-1)/2; i ++) 
			swap(num[i],num[num.size()-(i-j)]);
    }
};