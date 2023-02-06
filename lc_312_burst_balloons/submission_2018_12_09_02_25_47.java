

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int [] Nums = new int [n + 2];
        Nums[0] = Nums[n + 1] = 1;
        for(int i = 1; i <= n; i++)
        	Nums[i] = nums[i - 1];

        //dp[i][j] -> maxCoins(nums[i], nums[j]);
        //init 0, default
        int [][] dp = new int [n + 2][n + 2];
        for(int l = 1; l <= n; l++){
        	for(int i = 1; i <= n - l + 1; i++){
        		int j = i + l - 1;
        		for(int k = i; k <= j; k++){
        			//for i >= j , dp[i][j] = 0;
        			dp[i][j] = Math.max(dp[i][j],
        			 					dp[i][k - 1] + dp[k + 1][j] +
        								Nums[i - 1] * Nums[k] * Nums[j + 1]);
        		}
        	}
        }

        return dp[1][n];
    }
}