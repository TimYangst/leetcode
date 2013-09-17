#include <vector>
using namespace std;
class Solution {
public:
    void sortColors(int A[], int n) {
        vector<int> color(3,0);
		for  (int i = 0; i < n ;i++) color[A[i]]++;
		int j=0;
		for (int i=0;i<3;i++)
			while (color[i] >0){
				color[i] --;
				A[j++]= i;
			}
    }
};