

class Solution {
    public int minPathSum(int[][] grid) {
    	int m = grid.length;
    	if(m == 0) return 0;
    	int n = grid[0].length;
    	int [][] memo = new int [m][n];
    	return minSum(grid, memo, m - 1, n - 1);
    }

    private int minSum(int [][] grid, int [][] memo, int i, int j){
    	if(i < 0 || j < 0) return Integer.MAX_VALUE;
    	if(i == 0 && j == 0) return grid[i][j];
    	if(memo[i][j] > 0) return memo[i][j];
    	int ans = grid[i][j] + Math.min(minSum(grid, memo, i - 1, j), minSum(grid, memo, i, j - 1));
    	return memo[i][j] = ans;
    }
}