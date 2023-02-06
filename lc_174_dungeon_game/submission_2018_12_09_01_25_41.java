

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length ;
        int [][] dp = new int[m + 1][n + 1];
        for(int [] d: dp)
        	Arrays.fill(d, Integer.MAX_VALUE);
        dp[m - 1][n] = dp[m][n - 1] = 1;
        for(int i = m - 1; i >= 0; i--){
        	for(int j = n - 1; j >= 0; j--){
        		dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
        	}
        }
        return dp[0][0];
    }
}