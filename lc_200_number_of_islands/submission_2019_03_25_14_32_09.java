

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    ans++;
                    dfs(grid, i, j, m, n);
                }
            }
        return ans;
    }
    
    public void dfs(char [][] grid, int i, int j, int m, int n){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0')
            return;          
        grid[i][j] = '0';
        int [] dirs = {-1, 0, 1, 0, -1};
        for(int k = 0; k < 4; k++){
            int ni = i + dirs[k];
            int nj = j + dirs[k + 1];
            dfs(grid, ni, nj, m, n);
        }
    }
}