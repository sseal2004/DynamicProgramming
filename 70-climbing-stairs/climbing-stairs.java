class Solution {
    public int climbStairs(int n) {
       int []dp = new int[n+1];
       Arrays.fill(dp,-1);
       return helper(dp,n);
    }
    public int helper (int []dp,int n){
        if(n==0)return 1;
       if(n==1)return 1;
       if(dp[n]!=-1)return dp[n];
       int left = helper(dp,n-1);
       int right=helper(dp,n-2);
       return dp[n]=left+right;
    }
}