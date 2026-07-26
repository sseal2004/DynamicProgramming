class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n =cost.length;
        int []dp  =new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,cost,dp);
    }
    public  int helper (int index,int[]cost,int[]dp){
        if(index<=1) return 0;
        if(dp[index]!=-1)return dp[index];
        int left = helper(index-1,cost,dp) + cost[index-1];
        int right = Integer.MAX_VALUE;// f(1) is left + right then right is MAX_VAL
        if(index>1)
         right = helper(index-2,cost,dp) + cost[index-2];
        return dp[index] = Math.min(left,right);
    }
}