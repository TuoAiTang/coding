

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n < 2) return 0;
        int [] dp = new int [n + 1];
        for(int i = n - 3; i >= 0; i--)
            dp[i] = Math.min(dp[i + 1] + cost[i + 1], dp[i + 2] + cost[i + 2]);
        return Math.min(dp[0] + cost[0], dp[1] + cost[1]);
    }
}