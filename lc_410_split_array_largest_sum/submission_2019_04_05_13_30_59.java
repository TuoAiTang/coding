

class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int [] sums = new int [n];
        sums[0] = nums[0];
        for(int i = 1; i < n; i++)
            sums[i] = sums[i - 1] + nums[i];
        int [][] dp = new int [m + 1][n];
        for(int [] d : dp)
            Arrays.fill(d, Integer.MAX_VALUE);
        for(int i = 0; i < n; i++)
            dp[1][i] = sums[i];
        
        for(int l = 2; l <= m; l++){
            for(int j = 0; j < n; j++)
                for(int k = 0; k < j; k++){
                    dp[l][j] = Math.min(dp[l][j], 
                                        Math.max(dp[l - 1][k], sums[j] - sums[k]));
                }
        }
        return dp[m][n - 1];
    }   
}