

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        //dp[i][j] -> i-th row, j-th col, minmumTotal(i, j);
        int [][] dp = new int[n + 1][n + 1];
        for(int [] d : dp)
        	Arrays.fill(d, Integer.MAX_VALUE);

        for(int i = 1; i <= n; i++)
        	for(int j = 1; j <= i; j++){
        		dp[i][j] = triangle.get(i - 1).get(j - 1);
        		if(i == 1 && j == 1) continue;
        		if(j == 1) dp[i][j] += dp[i - 1][j];
        		else if(j == i) dp[i][j] += dp[i - 1][j - 1];
        		else dp[i][j] += Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
        	}

       	int ans = Integer.MAX_VALUE;
       	for(int i = 1; i <= n; i++)
       		ans = Math.min(ans, dp[n][i]);
       	return ans;
    }
}