

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int [] dp = new int [n];
        dp[n - 1] = 0;
        
        for(int i = n - 2; i >= 0; i--){
            dp[i] = Integer.MAX_VALUE;
            for(int k = 1; k <= nums[i]; k++){
                if(i + k == n - 1){
                    dp[i] = 1;
                    break;
                }
                if(dp[i + k] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i + k] + 1, dp[i]);
            }
        }
        return dp[0] != Integer.MAX_VALUE;
    }   
}