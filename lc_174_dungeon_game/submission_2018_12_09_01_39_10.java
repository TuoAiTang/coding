

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length ;
        int [] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 1;
        //dp[j] -> the lowest hp before the knights step into j column
        for(int i = m - 1; i >= 0; i--){
        	for(int j = n - 1; j >= 0; j--){
        		dp[j] = Math.max(1, Math.min(dp[j], dp[j + 1]) - dungeon[i][j]);
        	}
        }
        return dp[0];
    }
}