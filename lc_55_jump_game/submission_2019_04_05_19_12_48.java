

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int [] dp = new int [n];
        dp[n - 1] = n - 1;
        for(int i = n - 2; i >= 0; i--){
            int icr = nums[i];
            for(int j = 1; j <= icr; j++){
                if(i + j == n - 1){
                    dp[i] = n - 1;
                    break;
                }else{
                    dp[i] = Math.max(dp[i], dp[i + j]);
                }
            }
        }
        return dp[0] == n - 1;
    }   
}