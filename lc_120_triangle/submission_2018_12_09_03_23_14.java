

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        //dp[i] -> i-th row minmumTotal(i);
        int [][] dp = new int[2][n + 1];
        for(int [] d : dp)
        	Arrays.fill(d, Integer.MAX_VALUE);

        int cur = 1;
        int pre = 0;

        for(int i = 1; i <= n; i++){
        	for(int j = 1; j <= i; j++){
        		dp[cur][j] = triangle.get(i - 1).get(j - 1);
        		if(i == 1 && j == 1) continue;
        		if(j == 1) dp[cur][j] += dp[pre][j];
        		else if(j == i) dp[cur][j] += dp[pre][j - 1];
        		else dp[cur][j] += Math.min(dp[pre][j], dp[pre][j - 1]);
        	}
        	int tmp = cur;
        	cur = pre;
        	pre = tmp;
        }

       	int ans = Integer.MAX_VALUE;
       	for(int i = 1; i <= n; i++)
       		ans = Math.min(ans, dp[pre][i]);
       	return ans;
    }
}