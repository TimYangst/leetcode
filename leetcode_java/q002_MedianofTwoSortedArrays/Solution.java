package q002_MedianofTwoSortedArrays;

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int b1,e1,b2,e2;
        b1 =0;
        e1 = A.length - 1;
        b2 = 0;
        e2 = B.length - 1;
        int total = A.length + B.length;
        while (total > 2){
            if (b1 > e1){
                while (total > 2){
                    b2 ++ ;
                    e2 --;
                    total -= 2;
                }
                break;
            }
            if (b2 > e2){
                while (total > 2)
                {
                    b1 ++;
                    e1 --;
                    total -= 2;
                }
                break;
            }
            if (A[b1] <= B[b2])
            {
                b1 ++;
            }else {
                b2 ++;
            }
            if (B[e2] >= A[e1])
            {
                e2 --;
            } else {
                e1 --;
            }    
            total -= 2;
        }
        Double sum = 0.0;
        while (b1 <= e1)
        {
            sum += A[b1];
            b1++;
        }
        while (b2 <= e2)
        {
            sum += B[b2];
            b2++;
        }
        sum = sum / total;
        return sum;
    }
}