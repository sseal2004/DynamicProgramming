class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums,target,0,0);
    }
    int solve (int[]arr,int target,int ind,int sum){
        if(ind>=arr.length) return sum == target?1:0;

        int diff = solve(arr,target,ind+1,sum-arr[ind]);
        int add = solve(arr,target,ind+1,sum+arr[ind]);
        return diff+add;
    }
}