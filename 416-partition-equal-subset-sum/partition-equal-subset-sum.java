class Solution {

    public boolean helper(int[]arr,int target){
        int n = arr.length;
        boolean [][] dp= new boolean[n][target+1];
        if(arr[0]<=target) dp[0][arr[0]]=true;
        for(int i=0;i<n;i++)dp[i][0]=true;

        for(int i = 1;i<n;i++){
            for(int t=1;t<=target;t++){
                boolean take = false;
                boolean nottake = dp[i-1][t];
                if(arr[i]<=t)
                take = dp[i-1][t-arr[i]];
                dp[i][t] = take||nottake?true:false;
            }
        }
        return dp[n-1][target];
    }

    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0)return false;
        int target=sum/2;
        return helper(nums,target);
    }
}