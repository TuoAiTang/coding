

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) return 0;
        int [] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++){
        	if(nums[i] > nums[i - 1])
        		dp[i] = dp[i - 1] + 1;
        	else
        		dp[i] = 1;
        }
        int ans = -1;
        for(int d : dp)
        	ans = Math.max(ans, d);
        return ans;
    }
}