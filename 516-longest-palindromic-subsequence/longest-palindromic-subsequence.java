class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder s2 = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            s2.append(s.charAt(i));
        }
        return lcs(s,s2.toString());
    }
    static int lcs(String s1,String s2){
        if(s1.length()!=s2.length())return 0;
        int n = s1.length();int m = s2.length();
        int[][]dp= new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{
                     dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);

                 }
            }
        }
        return dp[n][m];

    }
}