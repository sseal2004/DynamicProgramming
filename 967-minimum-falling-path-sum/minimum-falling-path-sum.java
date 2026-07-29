class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n= matrix.length;
        int m = matrix[0].length;
        int [][]dp= new int [n][m];
        for(int j=0;j<n;j++)
           dp[0][j] =  matrix[0][j]; 
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
               int up=matrix[i][j] + dp[i-1][j];
               int leftdiagonal = matrix[i][j] +(j>0?dp[i-1][j-1]:(int)1e9);
               int rightdiagonal = matrix[i][j] +(j<m-1?dp[i-1][j+1]:(int)1e9);

               dp[i][j] = Math.min(up,Math.min(leftdiagonal,rightdiagonal));
            }
        }
        int ans = (int)1e7;
        for(int j=0;j<m;j++) ans = Math.min(ans,dp[n-1][j]);

        return ans;
    }
}