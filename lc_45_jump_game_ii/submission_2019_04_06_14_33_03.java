

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int [] dp = new int [n];
        dp[n - 1] = 0;
        int dpi;
        for(int i = n - 2; i >= 0; i--){
            dpi = Integer.MAX_VALUE;
            int step = nums[i];
            if(i + step >= n - 1)
                dpi = 1;
            else{
                for(int k = 1; k <= step; k++)
                    if(dp[i + k] != Integer.MAX_VALUE)
                        dpi = Math.min(dp[i + k] + 1, dpi);
            }
            dp[i] = dpi;
        }
        return dp[0];
    }
}