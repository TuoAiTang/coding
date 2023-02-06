

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int [] Nums = new int [n + 2];
        Nums[0] = Nums[n + 1] = 1;
        for(int i = 1; i <= n; i++)
        	Nums[i] = nums[i - 1];

        //dp[i][j] -> maxCoins(nums[i], nums[j]);
        //init 0, default
        int [][] dp = new int[n + 2][n + 2];

        return dfs(1, n, Nums, dp);
    }
    
    private int dfs(int i, int j, int [] nums, int [][] dp){
    	if(i > j) return 0;
    	if(i == j) return nums[i - 1] * nums[i] * nums[i + 1];
    	if(dp[i][j] > 0) return dp[i][j];
    	int ans = 0;
    	for(int k = i; k <= j; k++)
    		ans = Math.max(ans, dfs(i, k - 1, nums, dp)
    							+ nums[i - 1] * nums[k] * nums[j + 1]
    							+ dfs(k + 1, j, nums, dp));
    	dp[i][j] = ans;
    	return ans;
    }
}