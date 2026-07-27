class Solution {
    public int rob(int[] nums) {

       int n = nums.length;
        if(n<=0)return 0;
        if(n==1)return nums[0];
        int[] temp1 = new int[n - 1]; // Exclude first house
        int[] temp2 = new int[n - 1]; // Exclude last house
         int idx1 = 0, idx2 = 0;
         for(int i=0;i<n;i++){
            if(i!=0)  temp1[idx1++]= nums[i];
            if(i!=n-1) temp2[idx2++]= nums[i];
         }
        return Math.max(houseRobber1(temp1),houseRobber1(temp2));
    }
    public int houseRobber1(int[]nums){
        int n = nums.length;
        int[]dp= new int[n+1];
        dp[0] = nums[0];
        for(int i=1;i<n;i++){
            int pick = nums[i];
            if(i>1) pick = nums[i] + dp[i-2];
            int notpick = 0 + dp[i-1];

            dp[i]= Math.max(pick,notpick);

        }
        return dp[n-1];

    }
}