package q115_DistinctSubsequences;

public class Solution {
    public int numDistinct(String S, String T) {
        int[][] rst = new int[S.length()+1][T.length()+1];
        rst[0][0] =1 ;
        for (int j = 0;j<T.length();j++) rst[0][j+1]=0;
        for (int i = 0;i<S.length();i++) rst[i+1][0]=1;
        for (int i = 0; i< S.length();i++)
            for (int  j = 0 ; j <T.length(); j++){
                rst[i+1][j+1]= rst[i][j+1];
                if (S.charAt(i) == T.charAt(j)) rst[i+1][j+1] += rst[i][j];
            }
        return rst[S.length()][T.length()];
    }
}